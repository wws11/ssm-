package com.soecode.lyf.demo.test.thread;

/**
 * @author 魏文思
 * @date 2019/10/12$ 16:34$
 */
public class MyRunner  implements  Runnable {
    @Override
    public void run() {
        for(int  i=0;i<100;i++){
            System.out.println("myRunnable:"+i);

            try {
                System.out.println(Thread.currentThread().getName()+"休眠 5秒");
                Thread.sleep(5000);
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }
}
