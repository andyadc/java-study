package com.andyadc.designpattern.strategy.ducksimulate.oo;

/**
 * @author andaicheng
 * @version 2017/1/11
 */
public class GreenHeadDuck extends Duck {

    @Override
    public void display() {
        System.out.println("**GreenHead**");
    }

    @Override
    public void fly() {
        System.out.println("~~no fly~~");
    }
}
