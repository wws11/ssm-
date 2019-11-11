package com.soecode.lyf.demo.test.design.proxy.staticproxy;

/**
 * @author 魏文思
 * @date 2019/10/14$ 13:52$
 */
public class RealObject implements Action {
    @Override
    public void doSomething() {
        System.out.println("do  something sleep sleep  sleep ");
    }
}
