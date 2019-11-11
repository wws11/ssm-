package com.soecode.lyf.demo.test.thread.CountDownLatchTest;

import java.util.concurrent.CountDownLatch;

/**
 * countdownlatch一个或者多个线程，等待其他线程我完成某件事之后，等待其他多个线程完成某件事情之后才能执行。
 * cyclicbarrier多个线程互相等待，直到到达一个同步点，再继续一起执行
 * @author 魏文思
 * @date 2019/10/14$ 17:49$
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        for(int i=0;i<5;i++){
            new Thread(new ReadNum(i,countDownLatch)).start();
        }
        countDownLatch.await();
        System.out.println("线程执行结束。。。。");
    }

    static class ReadNum  implements Runnable{
        private int id;
        private CountDownLatch latch;
        public ReadNum(int id,CountDownLatch latch){
            this.id = id;
            this.latch = latch;
        }
        @Override
        public void run() {
            synchronized (this){
                System.out.println("id:"+id);
                latch.countDown();
                System.out.println("线程组任务"+id+"结束，其他任务继续");
            }
        }
    }


}
