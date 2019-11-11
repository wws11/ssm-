package com.soecode.lyf.demo.test.thread.futuretask;

import java.util.concurrent.Callable;

/**
 * @author 魏文思
 * @date 2019/10/15$ 8:48$
 */
public class MyTask  implements Callable {

    private String args1;
    private String args2;
    //构造函数，用来向task中传递任务的参数
    public  MyTask(String args1,String args2) {
        this.args1=args1;
        this.args2=args2;
    }
    @Override
    public Object call() throws Exception {
        Thread.sleep(5000);
        for (int i = 0; i < 100; i++) {
            System.out.println(args1+args2);
        }
        return true;
    }
}
