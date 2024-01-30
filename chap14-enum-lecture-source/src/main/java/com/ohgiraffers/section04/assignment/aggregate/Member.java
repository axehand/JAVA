package com.ohgiraffers.section04.assignment.aggregate;

import java.io.Serializable;
import java.util.Arrays;

/* 설명. 객체 입출력의 대상이 되는 클래스이자 엔티티 개념의 클래스(DB에 저장된 데이터를 담거나 넣을 데이터를 담을 객체) */
public class Member implements Serializable {
    private int memNo;                  // 회원번호
    private String id;                  // 회원아이디
    private String pwd;                 // 회원비번
    private int age;                    // 회원나이
    private String[] hobbies;           // 회원취미들
    private BloodType bloodType;        // 혈액형
    private MBTI mbti;

    /* 설명. 엔티티 클래스는 setter를 꼭 필요한 것만 만든다. */

    public Member() {
    }

    public Member(int memNo, String id, String pwd, int age, String[] hobbies, BloodType bloodType, MBTI mbti) {
        this.memNo = memNo;
        this.id = id;
        this.pwd = pwd;
        this.age = age;
        this.hobbies = hobbies;
        this.bloodType = bloodType;
        this.mbti = mbti;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memNo=" + memNo +
                ", id='" + id + '\'' +
                ", pwd='" + pwd + '\'' +
                ", age=" + age +
                ", hobbies=" + Arrays.toString(hobbies) +
                ", bloodType=" + bloodType +
                ", mbti=" + mbti +
                '}';
    }

    public int getMemNo() {
        return memNo;
    }

    public String getId() {
        return id;
    }

    public String getPwd() {
        return pwd;
    }

    public int getAge() {
        return age;
    }

    public String[] getHobbies() {
        return hobbies;
    }

    public BloodType getBloodType() {
        return bloodType;
    }
}
