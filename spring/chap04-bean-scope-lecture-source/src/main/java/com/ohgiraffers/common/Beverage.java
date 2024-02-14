package com.ohgiraffers.common;

public class Beverage extends Product{

    private  int capacity;

    public Beverage(){

    }

    public Beverage(String name, int price, int capacity) {
        super(name, price);
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Beverage{" +
                "capacity=" + capacity +
                "} " + super.toString();
    }
}
