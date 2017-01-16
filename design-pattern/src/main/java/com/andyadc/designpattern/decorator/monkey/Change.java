package com.andyadc.designpattern.decorator.monkey;

/**
 * @author andaicheng
 * @version 2017/1/16
 */
public class Change implements TheGreatestSage {
    private TheGreatestSage sage;

    public Change(TheGreatestSage sage) {
        this.sage = sage;
    }

    @Override
    public void move() {
        sage.move();
    }
}
