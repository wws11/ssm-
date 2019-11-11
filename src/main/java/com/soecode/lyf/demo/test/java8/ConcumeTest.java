package com.soecode.lyf.demo.test.java8;

import org.junit.Test;

import java.util.function.Consumer;

/** Consumer 接受T没有返回类型提供一个对象，需要拿这个对象去做一些事情，并不关心最终有无返回值。
    （g）->{
       这里需要别人提供了一个这样的对象再去做事情
 }
 * @author 魏文思
 * @date 2019/11/9$ 11:36$
 */
public class ConcumeTest {

    @Test
    public void cutHand() {
        Goods goods = new Goods("口红", 288);

        spentMoney(goods, (g) -> System.out.println("消费" + g.getCost() + "元"));

        System.out.println("-------------------贫富分割线--------------------");


        spentMoneyAndLog(goods, (g) -> System.out.println("消费" + g.getCost() + "元"));
    }


    public void spentMoney(Goods goods, Consumer<Goods> consumer) {
        consumer.accept(goods);
    }

    public void spentMoneyAndLog(Goods goods, Consumer<Goods> consumer) {
        Consumer<Goods> logConsumer = (g) -> System.out.println("买" + g.getGoodsName() + "用了" + g.getCost() + "元！");
        consumer.andThen(logConsumer).accept(goods);
    }

}
