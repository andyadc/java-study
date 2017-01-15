package com.andyadc.designpattern.decorator.cafe.decorator;

import com.andyadc.designpattern.decorator.cafe.Drink;

/**
 * @author andaicheng
 * @version 2017/1/14
 */
public class Milk extends Decorator {

    public Milk(Drink drink) {
        super(drink);

        super.setDescription("Milk");
        super.setPrice(2.5f);
    }
}
