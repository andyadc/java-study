package com.andyadc.designpattern.strategy.ducksimulate.duck;

import com.andyadc.designpattern.strategy.ducksimulate.behavior.impl.GaGaQuackBehavior;
import com.andyadc.designpattern.strategy.ducksimulate.behavior.impl.NoFlyBehavior;

/**
 * @author andaicheng
 * @version 2017/1/11
 */
public class GreenHeadDuck extends Duck {

    public GreenHeadDuck() {
        this.quackBehavior = new GaGaQuackBehavior();
        this.flyBehavior = new NoFlyBehavior();
    }

    @Override
    public void display() {
        System.out.println("**GreenHead**");
    }
}
