package baekjoon.codingtest;

import java.util.Arrays;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] n = new int[10];
        int[] result_n = new int[10];
        for (int i = 0; i <= 9; i++) {
            int input = sc.nextInt();
            n[i] = input;
            result_n[i] = n[i] % 42;
        }
        int count = 0;
        result_n = Arrays.stream(result_n).distinct().toArray();
        System.out.println(result_n.length);

    }
}
