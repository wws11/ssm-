package com.soecode.lyf.demo.test.java8.effectivejava.noInvalidObject;

import java.util.regex.Pattern;

/**
 * effective  java  第6条避免创建不必要的对象
 *
 * @author 魏文思
 * @date 2019/11/11$ 16:16$
 */
public class Test06 {

    /**
     * 1.避免创建不必要的对象，比如字符串的创建不使用new方式
     * 2.通过静态工厂方法可以创建不必要的对象
     * 3.对象的复用 如果一些对象可以被复用
     */
    //3.1比如校验正则
    static boolean isRomanNumeral(String s) {
        return s.matches("^(?=.)M*(C[MD]|D?C{0,3})" + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
    }

    /**
     * 这么写的问题:
     * 如果在临界的情况下重复使用，创建一次实例，并且只是用一次，之后它就有资格进行垃圾回收
     * 为了提高性能，作为类初始化的一部分，将正则表达式显示的编译为一个Pattenrn实例（不可变），缓存它，并在isRomanNumberal方法的每个调用中重复使用相同的实例。
     * 这个情景让我想到了之前碰到的一个面试题
     * gc对象回收比例远远大于8:1:1
     * 正常来说伊甸去和from和to区的回收比例是8：1：1但是出现了远远大于，这说明了什么？
     * 说明了大量创建了很多的临时变量，这些对象又被很快的被回收了
     * 像上面的正则字符串的创建，如果在并发的情况下可能会出现这种情况，但是如果使用下面的静态变量进行优化的话就不会产生这种情况
     */
    private static final Pattern ROMAN = Pattern.compile("^(?=.)M*(C[MD]|D?C{0,3})" + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");

    static boolean isRomanNumeral2(String s) {
        return ROMAN.matcher(s).matches();
    }

    //另一种避免创建不必要的对象的方法是自动装箱
    private static long sum() {
        Long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++) {
            sum += i;
        }
        return sum;
    }
    /**
     * 这个程序的结果是正确的，但是由于写错了一个字符，运行的结果要比实际慢很多。
     * 变量sum被声明成了Long而不是long,这意味着程序构造了大约231不必要的Long实例（每次往Long类型的sum变量中增加一个long类型的构造实例）
     * 总结：优先使用基本类型而不是装箱的基本类型，也要注意无意识的自动装箱
     */

}
