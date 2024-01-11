package com.ohgiraffers.section01.method;

public class Application3 {

    static int global = 10;               // 전역변수이자 클래스 변수

    public static void main(String[] args) {

        //int global = 20;                // 지역변수
        System.out.println("global = " + global);

        Application3 app3 = new Application3();
        app3.testMethod(10);
        app3.testMethod(19);
        app3.testMethod('a');
        app3.testMethod((int)12.34);
    }

    /* 설명. 정수를 주면 나이를 출력해주는 기능을 가진 메소드(non-static) */
    public void testMethod(int age) {
        System.out.println("당신의 나이는 " + age + "세 입니다.");
    }
}
