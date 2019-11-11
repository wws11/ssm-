package com.soecode.lyf.demo.test.java8.reflect;

import com.soecode.lyf.bookuserservice.pojo.Book;

/**
 * @author 魏文思
 * @date 2019/11/11$ 9:59$
 */
public class Jdk8ReflectTest {

    public static void main(String[] args) {
        getColumeName(Book::getName);
    }

    public static <T,R>  void  getColumeName(TypeFunction<T,R>  name){
        String lambdaColumnName = TypeFunction.getLambdaColumnName(name);
        System.out.println(lambdaColumnName);
    }
}
