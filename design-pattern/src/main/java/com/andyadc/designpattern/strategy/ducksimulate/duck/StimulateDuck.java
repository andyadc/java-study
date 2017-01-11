package com.andyadc.designpattern.strategy.ducksimulate.duck;

import com.andyadc.designpattern.strategy.ducksimulate.behavior.impl.GoodFlyBehavior;

/**
 * @author andaicheng
 * @version 2017/1/11
 */
public class StimulateDuck {

    public static void main(String[] args) {

        Duck green = new GreenHeadDuck();
        green.display();

        //重新set
        green.setFlyBehavior(new GoodFlyBehavior());
        green.fly();
    }
}
