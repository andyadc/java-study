package com.andyadc.concurrency.threadstudy;

import java.util.concurrent.TimeUnit;

/**
 * @author andy.an
 * @since 2018/3/6
 */
public class ThreadCooperation {

    public static void main(String[] args) {
        Cooperation cooperation = new Cooperation();

        Thread thread1 = new Thread(() ->
                cooperation.c1()
        );

        Thread thread2 = new Thread(() ->
                cooperation.c2()
        );

        Thread thread3 = new Thread(() ->
                cooperation.c3()
        );

        thread1.start();
        thread2.start();
        thread3.start();
    }

}

class Cooperation {

    public synchronized void c1() {
        try {
            System.out.println("-----------------");
            this.wait();
            System.out.println("-----------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized void c2() {
        try {
            System.out.println("+++++++++++++++++++");
            TimeUnit.SECONDS.sleep(3);
            System.out.println("+++++++++++++++++++");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void c3() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~");
    }
}

