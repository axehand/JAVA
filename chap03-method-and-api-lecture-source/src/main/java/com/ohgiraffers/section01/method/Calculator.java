package com.ohgiraffers.section01.method;

public class Calculator {

    public int plusTwoNumbers(int first, int second) {
        return first + second;
    }

    public int subTwoNumbers(int first, int second) {
        return first - second;
    }

    public int multiTwoNumbers(int first, int second) {
        return first * second;
    }

    public int devideTwoNumbers(int first, int second) {
        return first / second;
    }

    public int minTwoNumberOf(int first, int second) {
        return (first > second) ? second : first;
    }

    public int maxTwoNumberOf(int first, int second) {
        return (first > second) ? first : second;
    }

}
