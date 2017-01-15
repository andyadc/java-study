package com.andyadc.designpattern.decorator.cafe.coffee;

/**
 * @author andaicheng
 * @version 2017/1/14
 */
public class Espresso extends Coffee {

    public Espresso() {
        super.setDescription("Espresso");
        super.setPrice(4.0f);
    }
}
