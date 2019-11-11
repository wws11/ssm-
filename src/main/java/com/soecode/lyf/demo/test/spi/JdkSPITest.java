package com.soecode.lyf.demo.test.spi;

import org.junit.Test;

import java.util.ServiceLoader;

/**
 *
 * @author 魏文思
 * @date 2019/11/9$ 16:20$
 */
public class JdkSPITest {
    @Test
    public void sayHello() {
        ServiceLoader<Robot> load = ServiceLoader.load(Robot.class);
        System.out.println("Java SPI");
        load.forEach(Robot::sayHello);
    }
}
