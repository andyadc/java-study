package com.andyadc.designpattern.strategy.ducksimulate.behavior.impl;

import com.andyadc.designpattern.strategy.ducksimulate.behavior.FlyBehavior;

/**
 * @author andaicheng
 * @version 2017/1/11
 */
public class GoodFlyBehavior implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("--GoodFly--");
    }
}
