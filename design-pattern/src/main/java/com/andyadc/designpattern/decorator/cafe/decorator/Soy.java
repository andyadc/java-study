package com.andyadc.designpattern.decorator.cafe.decorator;

import com.andyadc.designpattern.decorator.cafe.Drink;

/**
 * @author andaicheng
 * @version 2017/1/14
 */
public class Soy extends Decorator {

    public Soy(Drink drink) {
        super(drink);

        super.setDescription("Soy");
        super.setPrice(1.5f);
    }
}
