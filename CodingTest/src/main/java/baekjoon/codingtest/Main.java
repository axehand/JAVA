package baekjoon.codingtest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
//hashSet대신 treeset을 사용하면 더 간단하게 끝낼 수 있다.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer[] input = new Integer[28]; //학생번호
        Integer[] students = new Integer[30]; //전체 학생번호
        for (int i = 1; i <= 30; i++) {
            students[i-1] = i; //1~30 까지의 전체 학생 번호 추가
        }
        for (int i = 0; i <= 27; i++) {
            input[i] = sc.nextInt(); //28명의 학생 번호 추가
        }
        // 두 배열을 비교해서 전체 학생중 과제를 안낸 학생의 번호를 알아내기 위해 hashset에 값을 저장
        Set<Integer> set1 = new HashSet<>(Arrays.asList(students));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(input));

        // 전체 학생번호에서 과제를 낸 학생번호를 빼서 안낸 학생을 찾아낸다.
        set1.removeAll(set2);

        // 결과 출력
        Integer[] result = set1.toArray(new Integer[0]);
        Arrays.sort(result);    //낮은 수 부터 정렬
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
