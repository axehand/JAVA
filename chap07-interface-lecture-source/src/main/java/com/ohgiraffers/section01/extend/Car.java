package com.ohgiraffers.section01.extend;

public class Car {

    private boolean runningStatus;

    public Car(){
        System.out.println("Car 클래스의 기본 생성자 호출됨...");
    }

    public boolean isRunning(){
        return runningStatus;
    }


    public void soundHorn(){
        if(isRunning())
        {
            System.out.println("빵! 빵!");
        }
        else{
            System.out.println("주행중이 아닐 때는 경적을 울릴 수 없습니다.");
        }

    }
    public void run(){
        runningStatus = true;
        System.out.println("자동차가 달리기 시작합니다.");
    }

    public void stop(){
        if(isRunning())
        {
            runningStatus = false;
            System.out.println("자동차가 멈춥니다.");
        }
        else{
            System.out.println("차가 이미 멈춰있습니다.");
        }
    }

}
