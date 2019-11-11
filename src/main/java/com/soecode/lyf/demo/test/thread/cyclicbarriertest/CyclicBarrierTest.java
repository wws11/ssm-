package com.soecode.lyf.demo.test.thread.cyclicbarriertest;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *
 *
 *
 *
 *
 * @author chiwei
 * @version
 * @since JDK 1.6
 * @see
 */
public class CyclicBarrierTest {

    public static void main(String[] args) {
        ThreadPoolExecutor poolExe = new ThreadPoolExecutor(100, 1000, 1, TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>(100));
        int count = 10;
        // 考试开始铃声响起，考试开始
        final CountDownLatch examBegin = new CountDownLatch(1);
        // 单个考生，考试结束交卷
        final CyclicBarrier student = new CyclicBarrier(count+1);

        // 一个考场10位考生
        for (int i = 0; i < count; i++) {
            Runnable runnable = new Runnable() {
                public void run() {
                    try {
                        System.out.println("考生" + Thread.currentThread().getName() + "在等待考试开始的铃声响起");
                        examBegin.await();
                        System.out.println("考生听到铃声" + Thread.currentThread().getName() + "开始答题");
                        Thread.sleep((long) (Math.random() * 100));//答题过程，真正的业务逻辑处理部分
                        System.out.println("考生" + Thread.currentThread().getName() + "交卷");
                        student.await();
                        //CycliBarrier的await方法的确阻塞当前线程的继续执行，只有计数到0才会得以全部继续执行
                        System.out.println("看看CyclicBarrier的await方法能不能把我阻塞住！"+Thread.currentThread().getName());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            poolExe.execute(runnable);
        }

        try {
            // 答题时间
            Thread.sleep((long) (Math.random() * 10000));
            System.out.println("考场" + Thread.currentThread().getName() + "开始铃声即将响起");
            examBegin.countDown();
            System.out.println("考场" + Thread.currentThread().getName() + "考试开始铃声响起");
            student.await(); // 所有考生交卷
            System.out.println("考场" + Thread.currentThread().getName() + "考试结束");
        } catch (Exception e) {
            e.printStackTrace();
        }
        poolExe.shutdown();

    }

}