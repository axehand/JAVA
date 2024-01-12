package com.ohgiraffers.section01.method;

public class Application9 {
    public static void main(String[] args) {
        /* 수업목표. 다른 클래스에 작성한 메소드를 호출할 수 있다. */

        int first = 100;
        int second = 50;
        Calculator cal = new Calculator();
        System.out.println("두 수의 합 : " + cal.plusTwoNumbers(first, second));
        System.out.println("두 수 중 작은 값은 : " + cal.minTwoNumberOf(first, second));
        System.out.println("두 수 중 큰 값은 : " + cal.maxTwoNumberOf(first, second));
    }
}
