package com.soecode.lyf.demo.test.java8.reflect;

/**
 * @author 魏文思
 * @date 2019/11/11$ 9:59$
 */
public class Jdk8ReflectTest {

    public static void main(String[] args) {
        //getColumeName(Book::getName);
    if(1==1){
        throw  new  RuntimeException("测试乱码的处理");
    }
    }

    public static <T,R>  void  getColumeName(TypeFunction<T,R>  name){
        String lambdaColumnName = TypeFunction.getLambdaColumnName(name);
        System.out.println(lambdaColumnName);
    }
}
