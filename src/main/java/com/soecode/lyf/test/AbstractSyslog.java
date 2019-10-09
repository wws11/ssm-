package com.soecode.lyf.test;

/**
 * @author 魏文思
 * @date 2019/9/9$ 15:18$
 */
public interface AbstractSyslog {

    String   getOperFun() throws Exception;

    int   getNum();

    default   void  test(){
        System.out.println("hello  interface");
    }
}
