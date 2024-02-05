package com.ohgiraffers.chap06.section01.dp;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Application1 {
    public static int solution(int N) throws IOException {
        int[] dp = new int[N + 1];

        if(N>=3) dp[3] = 1;
        if(N>=5) dp[5] = 1;

        /* 설명.
         *  5킬로그램까지는 앞의 if문에서 처리 했기 때문에 6킬로그램부터(5킬로그램 이하는 1이 측정되어야 하므로 +1을 함)
         *  dp배열에 저장한다.(3킬로그램과 5킬로그램에 대한 개념을 해당 DP에 저장한다.)
         *  6번째 index까지 초기값을 설정해 주어야 정상적으로 동작함
         *  점화식에 dp[i-5]가 사용되기 때문
        * */

        for (int i = 6; i <= N; i++) {

            /* 설명. 한 종류의 봉지로만 설탕을 처리하는 경우 */
            if(i % 5 == 0){
                dp[i] = dp[i - 5] + 1;
            }else if(i % 3 == 0){
                dp[i] = dp[i - 3] + 1;
            }

            /* 설명. 한 종류가 아닌 봉지들로 설탕을 처리하는 경우 */
            else {

                /* 설명. 3 또는 5의 배수 구간이 아니지만 3 또는 5 킬로그램짜리 봉지를 하나 더 들고 갈 수 있는 경우라면(ex. 23kg) */
                if(dp[i - 3] != 0 && dp[i-5] != 0){
                    dp[i] = Math.min(dp[i - 3], dp[i - 5]) + 1;
                }
            }
            System.out.println(Arrays.toString(dp));
        }
        if(dp[N] == 0){
            return -1;
        }

        return dp[N];
    }
}
