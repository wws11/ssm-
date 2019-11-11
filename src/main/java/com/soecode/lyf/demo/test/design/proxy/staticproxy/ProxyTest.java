package com.soecode.lyf.demo.test.design.proxy.staticproxy;

/**
 * @author 魏文思
 * @date 2019/10/14$ 13:56$
 */
public class ProxyTest {

    public static void main(String[] args) {
        Proxy  proxy=new Proxy(new RealObject());
        proxy.doSomething();
    }
}
