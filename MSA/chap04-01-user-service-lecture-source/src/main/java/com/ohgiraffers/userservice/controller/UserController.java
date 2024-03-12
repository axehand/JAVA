package com.ohgiraffers.userservice.controller;

import com.ohgiraffers.userservice.dto.UserDTO;
import com.ohgiraffers.userservice.service.UserService;
import com.ohgiraffers.userservice.vo.HelloVO;
import com.ohgiraffers.userservice.vo.RequestUser;
import com.ohgiraffers.userservice.vo.ResponseUser;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/")
public class UserController {
    /* 설명. @Value와 같이 application.yml 또는 환경설정 값 불러오기 위해 추가(생성자 주입) */
    private Environment env;
    private HelloVO helloVO;

    private ModelMapper modelMapper;

    private UserService userService;

    @Autowired
    public UserController(Environment env, HelloVO helloVO, ModelMapper modelMapper, UserService userService){
        this.env = env;
        this.helloVO = helloVO;
        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    /* 설명.
     *  application.yml 파일로부터 설정 값을 불러오기 위해서는 두 가지 방법이 제공된다.
     *  1. Enviroment를 의존성 주입 받아 getProperty로 설정 키 값을 작성해 불러오는 방법
     *  2. @Value를 활용해 필드로 주입 받고 활용하는 방법
    * */

    /* 설명. 1. Enviroment 활용해 설정값 불러오기 (GetProperty) */
    @GetMapping("health_check")
    public String healthCheck() {

        /* 설명. first-service 어플리케이션 여러개 실행 시(스케일 아웃) 실행되는 어플리케이션 확인(포트 번호로) */
        /* 설명. Gateway의 lb(로드 밸런싱)를 통해 RoundRobin 방식으로 스위칭 됨을 확인 */
        return "I'm OK port at " + env.getProperty("local.server.port")
                + ", swcamp.message : " + env.getProperty("swcamp.message");
    }

    /* 설명. 2. @Value 활용해 설정값 불러오기(getter) */

    @GetMapping("/do_msa")
    public String doMsa() {
        return helloVO.getMessage();
    }

    /* 설명. 회원가입(POST - /users) */
    @PostMapping("/users")
    public ResponseEntity<ResponseUser> registUser(@RequestBody RequestUser user) {

        /* 설명. config server에서 제공하는 test.message값 확인 */
        System.out.println("config server의 설정값 확인: " + env.getProperty("test.message"));

        
        /* 설명. RequestUser -> UserDTO */
        UserDTO userDTO = modelMapper.map(user, UserDTO.class);

        /* 설명. 회원가입 비즈니스 로직 시작 */
        userService.registUser(userDTO);

        /* 설명. UserDTO -> ResponseUser */
        ResponseUser responseUser = modelMapper.map(userDTO, ResponseUser.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseUser);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<ResponseUser> getUser(@PathVariable("id") String id) {

        UserDTO userDTO = userService.getUserById(id);

        ResponseUser returnValue = modelMapper.map(userDTO, ResponseUser.class);

        return ResponseEntity.status(HttpStatus.OK).body(returnValue);
    }
}
