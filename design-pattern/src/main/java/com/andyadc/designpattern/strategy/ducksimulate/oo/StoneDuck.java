package com.andyadc.designpattern.strategy.ducksimulate.oo;

/**
 * @author andaicheng
 * @version 2017/1/11
 */
public class StoneDuck extends Duck {

    @Override
    public void display() {
        System.out.println("**StoneDuck**");
    }

    @Override
    public void quack() {
        System.out.println("~~no gaga~~");
    }

    @Override
    public void swim() {
        System.out.println("~~no swim~~");
    }

    @Override
    public void fly() {
        System.out.println("~~no fly~~");
    }
}
