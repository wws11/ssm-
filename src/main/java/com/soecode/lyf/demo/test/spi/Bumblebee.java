package com.soecode.lyf.demo.test.spi;

/**
 * @author 魏文思
 * @date 2019/11/9$ 16:16$
 */
public class Bumblebee  implements  Robot {
    @Override
    public void sayHello() {
        System.out.println(
                "Hello I am Bumblee."
        );
    }
}
