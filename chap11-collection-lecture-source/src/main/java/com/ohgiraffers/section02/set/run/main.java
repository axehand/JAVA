package com.ohgiraffers.section02.set.run;
import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        exam ex = new exam();
        int[] input = new int[6];

//        for (int i = 0; i < input.length; i++) {
//            input[i] = (int)(Math.random() * 45) + 1;
//            for (int j = 0; j < i; j++) {
//                if(input[i] == input[j]){
//                    i--;
//                    break;
//                }
//            }
//        }
        /* 설명. while문을 이용해서 중복없는 난수를 생성하는 코드 */
        for (int i = 0; i < input.length; i++) {
            input[i] = ex.RandomNumber(input, i);
            System.out.println(input[i]);
        }

        ex.bubbleSort(input);
        System.out.print(Arrays.toString(input));
    }
}
