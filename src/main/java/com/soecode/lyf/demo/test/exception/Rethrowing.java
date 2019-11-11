package com.soecode.lyf.demo.test.exception;

/**
 * @author 魏文思
 * @date 2019/11/11$ 14:30$
 */
public class Rethrowing {

    public static void f() throws Exception {
        System.out.println(" originating the exception in f()");
        throw new Exception("thrown from  f()");
    }

    public static void g() throws Throwable {
        try {
            f();
        } catch (Exception e) {
            System.out.println("Inside g().e.prinsackTrace()");
            e.printStackTrace();
            throw e;
            //使用这总异常的方式会使异常起源信息全部丢失，留下的是与新的throw有关的信息。
            //throw  e.fillInStackTrace();
        }
    }

    public  static  void main(String[] args) throws  Throwable{
        try{
            g();
        }catch (Exception e){
            System.out.println("caught in main,e.printStackTrace()");
            e.printStackTrace();
        }
    }
}
