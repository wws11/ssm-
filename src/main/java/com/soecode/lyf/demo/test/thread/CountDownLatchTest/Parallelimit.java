package com.soecode.lyf.demo.test.thread.CountDownLatchTest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 实现功能：模拟并发请求
 *
 * 个人分析，创建100个线程，每个线程执行countdown方法之后都会进行await方法进行等待，
 * 等到countdown的构造初始值变为0的时候所有线程都会并发的执行await方法后面的业务。
 *
 *  countdownlatch和cuclibarrier区别
 *  countdownlatch是一个计数器，线程完成一个记录一个，计数器递减，只能用一次
 *  CyclicBarrier的计数器更像一个阀门，需要所有线程都到达，然后继续执行，计数器递增，提供reset功能，可以多次使用
 *
 * @author 魏文思  使用countdownlatch模拟并发
 * @date 2019/10/14$ 10:22$
 */
public class Parallelimit {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        CountDownLatch countDownLatch = new CountDownLatch(100);
        for (int i = 0; i < 100; i++) {
            CountRunnable runnable = new CountRunnable(countDownLatch);
            executorService.execute(runnable);
        }
    }


    static class CountRunnable implements Runnable {
        private CountDownLatch countDownLatch;

        public CountRunnable(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            try {
                synchronized (countDownLatch) {
             //每个线程都会进行构造的值减1
                    countDownLatch.countDown();
                    System.out.println("thread counts = " + (countDownLatch.getCount()));
                }
                countDownLatch.await();
                //模拟并发之后的业务
                System.out.println("concurrency counts = " + (100 - countDownLatch.getCount()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
