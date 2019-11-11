package com.soecode.lyf.demo.test.java8;

import com.soecode.lyf.bookuserservice.pojo.Book;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * （）->{
 * 这个里面直接做事情，得到事情的结果
 * }
 * 直接给他一个值，得到这个值以后可以用这个值再去做其他的事情，相当于把这个值用东西包装了一层，换种方式给别人
 *
 * @author 魏文思
 * @date 2019/11/9$ 13:25$
 */
public class SupllyTest {


    public static void main(String[] args) {

        testSupplier(() -> Book.builder().id(12).name("dsfs").number(23).build());

    }

    public static <T> void testSupplier(Supplier<T> supplier) {
        T t = supplier.get();
        System.out.println(t);
    }


    public static <T> void testConsumer(Consumer<T> consumer, T t) {
        consumer.accept(t);
    }
}
