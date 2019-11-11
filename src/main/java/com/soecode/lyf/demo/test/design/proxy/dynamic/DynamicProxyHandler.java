package com.soecode.lyf.demo.test.design.proxy.dynamic;

import com.soecode.lyf.demo.test.design.proxy.staticproxy.Action;
import com.soecode.lyf.demo.test.design.proxy.staticproxy.RealObject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author 魏文思
 * @date 2019/10/14$ 14:09$
 */
public class DynamicProxyHandler implements InvocationHandler {
    private Object realObject;

    public DynamicProxyHandler(Object realObject) {
        this.realObject = realObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("扩展业务逻辑");
        return method.invoke(realObject,args);
    }

    public static void main(String[] args) {
        RealObject realObject = new RealObject();
        Action proxy = (Action) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{Action.class}, new DynamicProxyHandler(realObject));
        proxy.doSomething();

    }
}
