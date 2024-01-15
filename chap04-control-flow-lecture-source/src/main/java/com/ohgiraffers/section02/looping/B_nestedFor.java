package com.ohgiraffers.section02.looping;

import java.util.Scanner;

public class B_nestedFor {
    public void printGugudanFromTwoToNine() {

        /* 수업목표. 중첩된 for문의 흐름을 이해하고 적용할 수 있다. */
        /* 설명.
         *  2단
         *   2 * 1 = 2
         *   2 * 2 = 4
         *   2 * 3 = 6
         *   ...
         *   9 * 7 = 63
         *   9 * 8 = 72
         *   9 * 9 = 81
        * */

        for (int i = 2; i <=9 ; i++) {
            System.out.println(i + "단");
            for (int j = 1; j <= 9; j++) {
                System.out.println(i + " X " + j + " = " + (i * j));
            }
            System.out.println();
        }
    }

    public void printUpgradeGugudanFromTwoToNine() {
        /* 수업목표. inner for문을 메소드로 따로 모듈화 해보자.(하나의 기능 단위로 보고) */
        for (int dan = 2; dan <= 9; ++dan) {
            System.out.println(dan + "단 출력");
            printGugudanOf(dan);
            System.out.println();
        }
    }

    private void printGugudanOf(int dan) {
        for (int i = 1; i <= 9; i++) {
            System.out.println(dan + " X " + i + " = " + (dan * i));
        }
    }

    public void printStars() {
        Scanner sc = new Scanner(System.in);
        System.out.println("정수를 입력하시오: ");
//        int input  = sc.nextInt();

//        for (int i = 0; i <= input; i++) {
//            for (int j = input; j > i; j--) {
//                System.out.print(" ");
//            }
//            for (int j = 0; j < i; j++) {
//                System.out.print("*");
//            }
//           System.out.println(' ');

//        for (int i = 0; i <= 5; i+=2) {
//            for (int j = 5; j >= i; j-=2) {
//                System.out.print(" ");
//            }
//            for (int j = 0; j <= i; j++) {
//                System.out.print("*");
//            }
//            System.out.println(' ');
//        }
    }
}
