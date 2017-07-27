package com.andyadc.concurrency.basic;

/**
 * @author andaicheng
 * @version 2017/7/27
 */
public class Synchronized {

    public static void main(String[] args) {
        synchronized (Synchronized.class) {
        }
        m();
    }

    public static synchronized void m() {
    }
}
