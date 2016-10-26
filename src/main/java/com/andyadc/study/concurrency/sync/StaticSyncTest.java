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
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sync.syncM1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sync.staticSyncM1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        //thread1.join();

        thread2.start();
        //thread2.join();
        System.out.println("main");
    }
}


class StaticSync {

    public synchronized void syncM1() throws InterruptedException {
        System.out.println("syncM1");
        Thread.sleep(5000);
    }

    public synchronized void syncM2() throws InterruptedException {
        System.out.println("syncM2");
        Thread.sleep(5000);
    }

    public static synchronized void staticSyncM1() throws InterruptedException {
        System.out.println("staticSyncM1");
        Thread.sleep(5000);
    }

    public static synchronized void staticSyncM2() throws InterruptedException {
        System.out.println("staticSyncM2");
        Thread.sleep(5000);
    }

    public void noSyncM1() throws InterruptedException {
        System.out.println("noSyncM1");
        Thread.sleep(5000);
    }

    public void noSyncM2() throws InterruptedException {
        System.out.println("noSyncM2");
        Thread.sleep(5000);
    }
}