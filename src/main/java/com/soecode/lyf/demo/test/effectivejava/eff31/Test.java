package com.soecode.lyf.demo.test.effectivejava.eff31;

import com.soecode.lyf.demo.test.effectivejava.bean.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author 魏文思
 * @date 2019/11/13$ 14:36$
 */
public class Test {
    static Map<Class<?>, Object> fav = new HashMap<>();

    public static void main(String[] args) {
        put(String.class, "ddd");
        put(User.class, new User("sfs", 12));
        put(User.class,new User("fff",13));
        User fav = getFav(User.class);
        System.out.println(fav);
    }

    public static <T> void put(Class<T> type, T instance) {
        fav.put(Objects.requireNonNull(type), instance);
    }

    public static <T> T getFav(Class<T> type) {
        return type.cast(fav.get(type));
    }
}
