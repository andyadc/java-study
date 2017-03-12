package com.andyadc.concurrency.barrier;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;

/**
 * @author andaicheng
 * @version 2017/3/12
 */
public class BarrierDemo_1 {

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(2, new Runnable() {
            @Override
            public void run() {
                System.out.println("隧道已打通");
            }
        });

        new Thread(new Worker(barrier), "工人1").start();
        new Thread(new Worker(barrier), "工人2").start();

    }
}

class Worker implements Runnable {

    private CyclicBarrier barrier;

    public Worker(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(new Random().nextInt(1000));
            System.out.println(Thread.currentThread().getName() + "-到达汇合点");
            barrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
