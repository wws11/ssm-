package com.soecode.lyf.demo.test.effectivejava.exception;

import com.soecode.lyf.demo.test.effectivejava.bean.User;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/**
 * effective java  09
 * jdk 的try -with-resources 测试
 *
 * @author 魏文思
 * @date 2019/11/12$ 14:19$
 */
public class ExceptionTest09 {

    public static void main(String[] args) {

        /**
         * 这种写法只是java的一种语法糖  如果你编写的类表示必须关闭的资源，那么这个类也应该实现 AutoCloseable 接口。
         * 当这个try catch块执行完毕之后会自动的将资源进行关闭
         * FileInputStream 这个类的最顶层接口是 AutoCloseable 接口 这个接口只有一个方法的定义 public void close() throws IOException;
         */
        try (FileInputStream inputStream = new FileInputStream(new File("test"))) {
            System.out.println(inputStream.read());
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    //上面的写法等效于下面的写法
    public void testIo() {
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(new File("test"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }

    @Test
    public void testComparable() {
        List<User> userList = new ArrayList<User>() {{
            add(new User("艾什", 18));
            add(new User("李四", 18));
            add(new User("李爱", 18));
            add(new User("王五", 18));
            add(new User("刘老汉", 19));
        }};
        System.out.println(userList);
        Collections.sort(userList, (o1, o2) -> {
            if (o1.getAge() > o2.getAge()) {
                return 1;
            } else if (o1.getAge() < o2.getAge()) {
                return -1;
            } else {
                Collator instance = Collator.getInstance(Locale.CHINA);
                return instance.compare(o1.getName(), o2.getName());
            }
        });
        System.out.println(userList);
    }
}
