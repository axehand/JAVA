package com.ohgiraffers.section01.literal;

public class Application1 {
    public static void main(String[] args) {
        //  한줄주석
        /* 범위 주석 */

        // 수업목표. 여러 가지 값의 형태를 출력할 수 있다.
        // 목차. 1. 숫자 형태의 값
        // 목차. 1-1. 정수 형태의 값 출력
        System.out.println(123);

        // 목차. 1-2. 실수 형태의 값 출력
        System.out.println(1.234);

        // 목차. 2. 문자 형태의 값 출력

        System.out.println('a');            // 필기. 문자는 single quatation('')을 적용
        System.out.println('1');            // 필기. 숫자도 single quatiotion(')을 붙이면 문자다.
        // System.out.println('ab');        // 필기. 문자의 경우 두글자이상이 되는 순간 컴파일 오류 발생
        // System.out.println('\u0000');    // 필기. 문자는 아무것도 안 넣으면 에러가 발생하지만 안넣고 싶으면 \u0000을 붙여야 한다.

        // 목차. 3. 문자열 형태의 값 출력
        System.out.println("안녕하세요");     // 필기. 문자열은 double quatation("")을 적용
        System.out.println("a");

        // 목차. 4. 논리 형태의 값 출력
        System.out.println(true);
        System.out.println("true");     // 필기. double quatation이 붙으면 문자열이 된다.
        System.out.println(false);      // 필기. true 또는 false 두 값만 논리 값이다.
    }
}
