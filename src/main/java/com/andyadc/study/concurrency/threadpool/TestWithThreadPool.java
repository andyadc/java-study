package com.andyadc.study.concurrency.threadpool;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author andaicheng
 * @version 2016/10/26
 */
public class TestWithThreadPool {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        final List<Integer> list = new LinkedList<>();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(100, 100, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>(20000));
        final Random random = new Random();
        for (int i = 0; i < 20000; i++) {
            executor.execute(() -> list.add(random.nextInt()));
        }

        executor.shutdown();

        try {
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(System.currentTimeMillis() - start);
        System.out.println(list.size());

    }

}
