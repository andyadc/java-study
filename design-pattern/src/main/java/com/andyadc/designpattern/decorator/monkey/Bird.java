package com.andyadc.designpattern.decorator.monkey;

/**
 * @author andaicheng
 * @version 2017/1/16
 */
public class Bird extends Change {

    public Bird(TheGreatestSage sage) {
        super(sage);
    }

    @Override
    public void move() {
        System.out.println("Bird Move");
    }
}
