package com.andyadc.concurrency.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * @author andy.an
 * @since 2017/11/22
 */
public class CountTask extends RecursiveTask<Long> {

    private static final long THRESHOLD = 100L; // 阈值

    private long start;
    private long end;

    public CountTask(long start, long end) {
        this.start = start;
        this.end = end;
    }

    public static void main(String[] args) throws Exception {
        long start = 1L;
        long end = 100000L;
        long s = System.currentTimeMillis();

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        CountTask task = new CountTask(start, end);
        Future<Long> future = forkJoinPool.submit(task);
        System.out.println(future.get());

//        long sum = 0;
//        for (long i = start; i <= end; i++ ) {
//            sum += i;
//        }
//        System.out.println(sum);

        System.out.printf("elapsed: %s ms", (System.currentTimeMillis() - s));
    }

    @Override
    protected Long compute() {
        long sum = 0L;
        boolean canCompute = (end - start) <= THRESHOLD;
        if (canCompute) {
            for (long i = start; i <= end; i++) {
                sum += i;
            }
        } else {
            long middle = (start + end) / 2;
            CountTask leftTask = new CountTask(start, middle);
            CountTask rightTask = new CountTask(middle + 1, end);

            leftTask.fork();
            rightTask.fork();

            long leftResult = leftTask.join();
            long rightResult = rightTask.join();

            sum = leftResult + rightResult;
        }

        return sum;
    }


}


