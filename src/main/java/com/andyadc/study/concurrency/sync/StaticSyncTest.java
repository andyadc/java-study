package com.andyadc.study.concurrency.sync;

/**
 * 如果一个线程执行一个对象的非static synchronized方法，另外一个线程需要执行这个对象所属类的static synchronized方法，此时不会发生互斥现象，
 * 因为访问static synchronized方法占用的是类锁，而访问非static synchronized方法占用的是对象锁，所以不存在互斥现象。
 * <p>
 * 对于synchronized方法或者synchronized代码块，当出现异常时，JVM会自动释放当前线程占用的锁，因此不会由于异常导致出现死锁现象。
 *
 * @author andaicheng
 * @version 2016/10/26
 */
public class StaticSyncTest {

    public static void main(String[] args) throws InterruptedException {
        StaticSync sync = new StaticSync();
        Thread thread1 = new Thread(() -> {
            sync.staticSyncM1();
        });

        Thread thread2 = new Thread(() -> {
            sync.syncM2();
        });

        thread1.start();
        thread2.start();

        System.out.println("main");
    }
}


class StaticSync {

    public synchronized void syncM1() {
        System.out.println("syncM1");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void syncM2() {
        System.out.println("syncM2");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static synchronized void staticSyncM1() {
        System.out.println("staticSyncM1");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static synchronized void staticSyncM2() {
        System.out.println("staticSyncM2");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void noSyncM1() {
        System.out.println("noSyncM1");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void noSyncM2() {
        System.out.println("noSyncM2");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}