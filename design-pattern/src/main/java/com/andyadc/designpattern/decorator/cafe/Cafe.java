package com.andyadc.designpattern.decorator.cafe;

import com.andyadc.designpattern.decorator.cafe.coffee.Decaf;
import com.andyadc.designpattern.decorator.cafe.coffee.LongBlack;
import com.andyadc.designpattern.decorator.cafe.decorator.Chocolate;
import com.andyadc.designpattern.decorator.cafe.decorator.Milk;

/**
 * @author andaicheng
 * @version 2017/1/14
 */
public class Cafe {

    public static void main(String[] args) {
        Drink order;
        order = new Decaf();
        System.out.println("order1 price:" + order.cost());
        System.out.println("order1 desc:" + order.getDescription());

        System.out.println("****************************");

        order = new LongBlack();
        order = new Milk(order);
        order = new Chocolate(order);
        order = new Chocolate(order);
        System.out.println("order2 price:" + order.cost());
        System.out.println("order2 desc:" + order.getDescription());


    }
}
