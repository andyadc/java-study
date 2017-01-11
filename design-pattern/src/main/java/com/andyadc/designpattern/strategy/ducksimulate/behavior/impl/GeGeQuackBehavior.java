package com.andyadc.designpattern.strategy.ducksimulate.behavior.impl;

import com.andyadc.designpattern.strategy.ducksimulate.behavior.QuackBehavior;

/**
 * @author andaicheng
 * @version 2017/1/11
 */
public class GeGeQuackBehavior implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("__GeGe__");
    }
}
