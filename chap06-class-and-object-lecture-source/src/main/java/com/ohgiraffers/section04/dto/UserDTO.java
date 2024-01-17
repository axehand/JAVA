package com.ohgiraffers.section04.dto;


import java.util.Date;



public class UserDTO {

    /* 필기. 1. 필드(멤버변수) */
    private String id;
    private String pwd;
    private String name;
    private java.util.Date enrollDate;

    /* 필기. 2. 생성자(기본생성자 필수로 명시적 작성 */
    public UserDTO(){

    }
    /* 필기 3. 설정자(setter)와 접근자(getter) */
    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
    /* 설명. 이후 나머지 setter, getter는 단축키로 만들자. */

    public UserDTO(String id, String pwd, String name, Date enrollDate) {
        this.id = id;
        this.pwd = pwd;
        this.name = name;
        this.enrollDate = enrollDate;
    }
    /* 필기. 4. 모든 멤버 변수를 String으로 반환하는 toString() */
    @Override
    public String toString() {
        return "UserDTO{" +
                "id='" + id + '\'' +
                ", pwd='" + pwd + '\'' +
                ", name='" + name + '\'' +
                ", enrollDate=" + enrollDate +
                '}';
    }
}


