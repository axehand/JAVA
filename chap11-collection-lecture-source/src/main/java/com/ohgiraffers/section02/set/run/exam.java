package com.ohgiraffers.section02.set.run;
public class exam {
    public void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    public int RandomNumber(int[] array, int index) {
        while (true) {
            int rand = (int)(Math.random() * 45) + 1;
            boolean isUnique = true;

            for (int i = 0; i <= index; i++) {
                if (array[i] == rand) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                return rand;
            }
        }
    }
}
