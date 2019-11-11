package com.soecode.lyf.demo.test.thread.futuretask;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * 使用futuretask 创建多个任务
 * @author 魏文思
 * @date 2019/10/15$ 9:07$
 */
public class ManyTaskTest {

    public static void main(String[] args) {
        //创建一个FutureTask list来放置所有的任务
        List<FutureTask<Object>> futureTasks=new ArrayList<>();
        for(Integer i=0;i<10;i++){
            MyTask myTask=new MyTask(i.toString(), i.toString());
            futureTasks.add(new FutureTask<>(myTask));
        }

        //创建线程池后，依次的提交任务，执行
        ExecutorService executorService= Executors.newCachedThreadPool();
        for(FutureTask<Object> futureTask:futureTasks){
            executorService.submit(futureTask);
        }
        executorService.shutdown();

        //根据任务数，依次的去获取任务返回的结果，这里获取结果时会依次返回，若前一个没返回，则会等待，阻塞
        for(Integer i=0;i<10;i++){
            try {
                boolean flag=(boolean)futureTasks.get(i).get();
                System.out.println(flag);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
