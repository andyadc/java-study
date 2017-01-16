package com.andyadc.designpattern.decorator.monkey;

/**
 * @author andaicheng
 * @version 2017/1/16
 */
public class Fish extends Change {

    public Fish(TheGreatestSage sage) {
        super(sage);
    }

    @Override
    public void move() {
        System.out.println("Fish Move");
    }
}
