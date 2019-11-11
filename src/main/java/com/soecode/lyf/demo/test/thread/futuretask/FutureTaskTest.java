package com.soecode.lyf.demo.test.thread.futuretask;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author 魏文思
 * @date 2019/10/14$ 19:39$
 */
public class FutureTaskTest {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyTask myTask = new MyTask("11", "22");

        FutureTask futureTask = new FutureTask(myTask);
        Thread thread = new Thread(futureTask);
        thread.start();
        System.out.println("测试是否 异步1");
        //获取任务的 执行结果，如果任务还没有完成则会阻塞等待，直到任务完成。如果任务被取消则会抛出CancelllationException异常
        //如果任务执行过程中发生异常则会抛出ExecutionException异常，如果阻塞等待过程中被中断则会抛出InterrupptedException
        boolean result = (boolean) futureTask.get();   //这个方法的调用会阻塞主线程
        System.out.println("测试是否 异步2");


    }


}
