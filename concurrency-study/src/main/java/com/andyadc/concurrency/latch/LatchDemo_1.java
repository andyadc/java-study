package com.andyadc.concurrency.latch;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @author andaicheng
 * @version 2017/3/10
 */
public class LatchDemo_1 {
    public static void main(String[] args) throws Exception {
        int num = 10;
        //发令枪只只响一次
        CountDownLatch begin = new CountDownLatch(1);
        //参与跑步人数
        CountDownLatch end = new CountDownLatch(num);

        ExecutorService es = Executors.newFixedThreadPool(num);

        //记录跑步成绩
        List<Future<Integer>> futures = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            futures.add(es.submit(new Runner(begin, end)));
        }

        //预备
        TimeUnit.SECONDS.sleep(10);

        //发令枪响
        begin.countDown();
        //等待跑者跑完
        end.await();

        int sum = 0;
        for (Future<Integer> f : futures) {
            sum += f.get();
        }

        System.out.println("平均分数: " + (float) (sum / num));
    }
}

class Runner implements Callable<Integer> {

    //开始信号
    private CountDownLatch begin;
    //结束信号
    private CountDownLatch end;

    public Runner(CountDownLatch begin, CountDownLatch end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    public Integer call() throws Exception {
        //跑步成绩
        int score = new Random().nextInt(10);

        //等待发令枪响
        begin.await();
        TimeUnit.SECONDS.sleep(score);
        //跑步结束
        end.countDown();
        System.out.println("score:" + score);
        return score;
    }
}
