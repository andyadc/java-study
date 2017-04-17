package com.andyadc.concurrency.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author andaicheng
 * @version 2017/4/17
 */
public class IntegerTest {

    public static void main(String[] args) {
        AtomicInteger ai = new AtomicInteger(1);
        System.out.println(ai);
        boolean flag = ai.compareAndSet(1, 2);
        System.out.println(flag);
        System.out.println(ai);
    }
}
