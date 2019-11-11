package com.soecode.lyf.demo.test.design.proxy.staticproxy;

/**
 * 代理对象
 * @author 魏文思
 * @date 2019/10/14$ 13:53$
 */
public class Proxy implements  Action {

    Action  realObject;

    public  Proxy(Action action) {
        this.realObject=action;
    }
    @Override
    public   void  doSomething(){
        System.out.println("代理 去做事情之前");
        realObject.doSomething();
        System.out.println("代理做事情之后");
    }
}
