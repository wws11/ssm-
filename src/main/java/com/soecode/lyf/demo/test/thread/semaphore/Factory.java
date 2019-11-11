package com.soecode.lyf.demo.test.thread.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 应用场景五个设备，8台生产工人，工人轮流使用设备
 *
 * @author 魏文思
 * @date 2019/10/15$ 9:29$
 */
public class Factory  implements   Runnable {

    private Semaphore semaphore;
    public  Factory (Semaphore semaphore){
        this.semaphore=semaphore;
    }
    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName()+"使用设备");
            TimeUnit.SECONDS.sleep(1);
            System.out.println(Thread.currentThread().getName()+"结束");
            semaphore.release();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Semaphore semaphore=new Semaphore(5);
        Factory factory=new Factory(semaphore);
        for (int i = 0; i <8; i++) {
            new  Thread(factory).start();

        }
    }
}
