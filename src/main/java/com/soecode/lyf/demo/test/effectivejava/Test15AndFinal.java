package com.soecode.lyf.demo.test.effectivejava;

import java.util.Collections;

/**
 * 如果一个方法重写一个超类方法，那么它在子类中的访问级别就不能低于父类中的访问级别。
 * 如果一个类实现了一个接口，那么接口中的所有类方法都必须在该类中声明为public。
 *
 * final  1.修饰类类不可被继承
 * 2.修饰方法 方法不可被继承
 * 3.修饰局部变量时只能初始化（复制一次）一次，但是也可以不初始化
 * 4.修饰方法的参数
 *    修饰方法的参数时，是在调用方法传递参数时初始化的
 * @author 魏文思
 * @date 2019/11/12$ 15:28$
 */
public class Test15AndFinal {
    public static void main(String[] args) {
        final   int a;
        a=2;
        //a=3;  这样写会有问题不能再次赋值
    test(8,9);   //此时x已经初始化为8 了，后面不允许再修改
    }

    public  static  void  test(final  int x, int y){
        //x=5; 这样再次去赋值会出现报错
        Collections.emptyList();
    }

}
