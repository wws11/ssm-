package com.soecode.lyf.demo.test.thread.futuretask;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @author 魏文思
 * @date 2019/10/15$ 9:05$
 */
public class FutrueTaskPool {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyTask myTask = new MyTask("11", "22");

        FutureTask futureTask = new FutureTask(myTask);

        //使用另一种方式来开启线程
        ExecutorService service = Executors.newCachedThreadPool();
        service.submit(futureTask);
        service.shutdown();
        boolean o = (boolean) futureTask.get();
        System.out.println(o);
    }
}
