package com.andyadc.designpattern.strategy.ducksimulate.duck;

import com.andyadc.designpattern.strategy.ducksimulate.behavior.FlyBehavior;
import com.andyadc.designpattern.strategy.ducksimulate.behavior.QuackBehavior;

/**
 * @author andaicheng
 * @version 2017/1/11
 */
public abstract class Duck {

    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public Duck() {
    }

    public void fly() {
        flyBehavior.fly();
    }

    public void quack() {
        quackBehavior.quack();
    }

    public abstract void display();

    public void swim() {
        System.out.println("~~im swim~~");
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }
}
