package com.andyadc.designpattern.decorator.cafe.coffee;

import com.andyadc.designpattern.decorator.cafe.Drink;

/**
 * @author andaicheng
 * @version 2017/1/14
 */
public class Coffee extends Drink {

    @Override
    public float cost() {
        return super.getPrice();
    }
}
