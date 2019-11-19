package com.soecode.lyf.demo.test.java8.reflect;


import com.soecode.lyf.demo.test.effectivejava.bean.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author 魏文思
 * @date 2019/11/16$ 13:47$
 */
public class IfElseTest {

    /*public static void main(String[] args) {
        Map<Integer, Function<Integer, User>> map = new HashMap<>();
        map.put(1, e -> {
            User person = new User("java", 23);
            System.out.println("测试function的加载时机");
            return person;
        });
        //如果map没有被调用，那么里面的打印语句不会执行    Person person = map.get(1).apply(1);//这么写没问题，可以被调用
        User apply = map.get(1).apply(1);
        System.out.println(apply);
    }*/

    @Test
    public void testOptional() {
       /* Optional.ofNullable(user).orElseGet(User::new).getName();
        String aaa = null;
        Optional.ofNullable(aaa).orElse("");

        Integer a = null;
        int b = 12 + a;
        Optional.ofNullable(a).orElse(0);*/


        List<User> userList = new ArrayList<>();
        userList.add(new User("张三", 12));
        Optional<List<User>> userListOption = Optional.of(userList);
            /**
            * filter
            */

        List<User> noZhangsanList = userListOption.filter(e -> !e.contains(new User("张三", 12))).orElseGet(ArrayList::new);
        System.out.println(noZhangsanList);
        /**
         * map
         */
        User user = new User("王五", null);
        Integer age = Optional.of(user).map(e -> e.getAge()).orElse(1);
        System.out.println(age);
        System.out.println(user.getAge());
        /**
         * ifPresent()
         */
        User user2 = new User("zhaosi", 1);
        Optional<String> s = Optional.of(user2).filter(e->e.getAge()==1).map(e -> e.getName());
        s.ifPresent(e-> {
            System.out.println();
            System.out.println("值存在");
        });


        /* *//**
         26          * filter
         27          *//*
        28         Insurance insurance1 = optional1.filter(i -> i.getName() == null).get();
        29         System.out.println(insurance1);
        30
        31         *//**
         32          * map
         33          *//*
        34         Optional<String> nameOptional = optional1.map(i -> i.getName());
        35         String s = nameOptional.orElse("empty value");
        36         System.out.println(s);
        37
        38         *//**
         39          * isPresent ifPresent
         40          *//*
        41         Insurance insurance3 = new Insurance();
        42         insurance3.setName("xiao wang");
        43         Optional<Insurance> optional3 = Optional.of(insurance3);
        44         Optional<String> nameOptional3 = optional3.filter(i -> i.getName().equals("xiao wang")).map(i -> i.getName());
        45         System.out.println(nameOptional3.isPresent());
        46         nameOptional3.ifPresent(i -> System.out.println("insurance name is ：" + i));
        47
        48         *//**
         49          * optional判断空写法
         50          *//*
        51         System.out.println(getInsuranceName(null));
        52         System.out.println(getInsuranceNameByOptional(null));*/
    }
}

