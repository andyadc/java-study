package com.andyadc.designpattern.strategy.ducksimulate.oo;

/**
 * @author andaicheng
 * @version 2017/1/11
 */
public class StimulateDuck {

    public static void main(String[] args) {
        Duck green = new GreenHeadDuck();
        green.fly();

        Duck stone = new StoneDuck();
        stone.quack();
    }
}
