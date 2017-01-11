package com.andyadc.designpattern.strategy.ducksimulate.oo;

/**
 * @author andaicheng
 * @version 2017/1/10
 */
public abstract class Duck {

    public Duck() {
    }

    public void quack() {
        System.out.println("~~gaga~~");
    }

    public abstract void display();

    public void swim() {
        System.out.println("~~im swim~~");
    }

    public void fly() {
        System.out.println("~~im fly~~");
    }

}
