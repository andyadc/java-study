package com.andyadc.study.concurrency.threadpool;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * @author andaicheng
 * @version 2016/10/26
 */
public class TestWithoutThreadPool {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        final List<Integer> list = new LinkedList<>();
        final Random random = new Random();

        for (int i = 0; i < 20000; i++) {

            Thread thread = new Thread(() -> list.add(random.nextInt()));

            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(System.currentTimeMillis() - start);
        System.out.println(list.size());

    }

}
