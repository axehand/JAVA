package com.ohgiraffers.restapi.section01.response;


import lombok.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Message {
    private int httpStatusCode;
    private String message;
}
