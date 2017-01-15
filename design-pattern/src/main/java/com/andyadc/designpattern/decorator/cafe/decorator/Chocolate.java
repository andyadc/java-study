package com.andyadc.designpattern.decorator.cafe.decorator;

import com.andyadc.designpattern.decorator.cafe.Drink;

/**
 * @author andaicheng
 * @version 2017/1/14
 */
public class Chocolate extends Decorator {

    public Chocolate(Drink drink) {
        super(drink);

        super.setDescription("Chocolate");
        super.setPrice(3.5f);
    }
}
