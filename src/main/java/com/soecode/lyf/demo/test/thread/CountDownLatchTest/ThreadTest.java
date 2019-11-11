package com.soecode.lyf.demo.test.thread.CountDownLatchTest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 魏文思
 * @date 2019/10/12$ 16:34$
 */
public class ThreadTest {

    public static void main(String[] args) {
        //这个类使一个线程等待其他线程各自执行完毕后在执行
        //是通过一个计数器来实现的，计数器的初始值是线程的数量每当一个线程执行完毕后。
        // 计数器的值就减1，当计数器的值为0的时候，表示所有线程都执行完毕，然后在闭锁上等待的线程就可以恢复工作了

        //第一个子线程
        final CountDownLatch latch = new CountDownLatch(2);
        System.out.println("主线程开始执行");
        ExecutorService es1 = Executors.newSingleThreadExecutor();
        es1.execute(() -> {
            try {
                Thread.sleep(3000);
                System.out.println("子线程：" + Thread.currentThread().getName() + "执行");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            latch.countDown();
            try {
                latch.await();
                //测试await方法用于子线程
                System.out.println("线程1又开始执行其他任务了。。。。。。。。。。。。");
                System.out.println("哈哈哈哈哈哈");
                System.out.println("线程1执行结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        es1.shutdown();
        //第二个线程执行
        ExecutorService es2 = Executors.newSingleThreadExecutor();
        es2.execute(()->{
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("子线程：" + Thread.currentThread().getName() + "执行");
            latch.countDown();
        });
        es2.shutdown();


        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("两个子线程都执行完毕，继续执行主线程，子线程里面使用await的线程也会继续执行");

    }
}
