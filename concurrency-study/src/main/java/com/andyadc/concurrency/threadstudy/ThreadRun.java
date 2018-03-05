package com.andyadc.concurrency.threadstudy;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * The JVM will exit when the main thread and all non-daemon threads finish execution.
 *
 * @author andy.an
 * @since 2018/3/5
 */
public class ThreadRun {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " begin");

        PrintThread pt1 = new PrintThread("a", "hello");
        PrintThread pt2 = new PrintThread("b", "world");

//        pt1.setDaemon(true);
//        pt1.start();

//        pt2.setDaemon(true);
//        pt2.start();

//        new RunningThread().start();

//        new SleepingThread().start();

//        task();

        ThreadFactory factory = Executors.defaultThreadFactory();
        factory.newThread(new RunningThread()).start();

        System.out.println(Thread.currentThread().getName() + " end");
    }

    private static void task() {
        new Timer(false).schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("TimerTask running...");
            }
        }, 100, 1000);
    }
}

class SleepingThread extends Thread {

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class RunningThread extends Thread {

    @Override
    public void run() {
        while (true) {
            System.out.println("I'm running...");
        }
    }
}

class PrintThread extends Thread {

    private String message;

    PrintThread(String name, String message) {
        super(name);
        this.message = message;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getName() + "-" + message + "-" + i);
        }
    }
}
