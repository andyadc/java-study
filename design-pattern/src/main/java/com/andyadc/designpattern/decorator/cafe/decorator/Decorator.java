package com.andyadc.designpattern.decorator.cafe.decorator;

import com.andyadc.designpattern.decorator.cafe.Drink;

/**
 * @author andaicheng
 * @version 2017/1/14
 */
public class Decorator extends Drink {

    private Drink drink;

    public Decorator(Drink drink) {
        this.drink = drink;
    }

    @Override
    public float cost() {
        return super.getPrice() + drink.cost();
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "-" + super.getPrice() + "&&" + drink.getDescription();
    }
}
