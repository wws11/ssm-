package com.soecode.lyf.demo.test.effectivejava.code20;

/**
 * @author 魏文思
 * @date 2019/11/12$ 17:56$
 */
public interface MyInterface {


    default String getName() {
        return "ok";
    }
}
