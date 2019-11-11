package com.soecode.lyf.demo.unzip;

import com.soecode.lyf.book.pojo.Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author 魏文思
 * @date 2019/9/4$ 13:42$
 */
public class CollectionsUtils {






    /**
     * 传进一个list 得到一个它的指定元素的集合
     */


    public <T> ArrayList<ArrayList<String>> getArrObjByNames(List<T> listData, ArrayList<String> nameS) {
        ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();

        for (T t : listData) {
            ArrayList<String> arr = new ArrayList<String>();
            for (String name : nameS) {
                String value = String.valueOf(Reflections.getFieldValue(t, name));
                arr.add(value);
            }
            list.add(arr);
        }
        return list;
    }

    public static <T,R> List<R> getAttrValue(List<T> ts, String attname) {
        List<R> result=new ArrayList();
        for (T t:ts){
            R fieldValue = (R) Reflections.getFieldValue(t, attname);
            result.add(fieldValue);
        }
        return result;
    }

    /**
     * 获取根据t获取去r中的任意字段映射
     *
     * @param map
     * @param t
     * @param function
     * @param <T>
     * @param <R>
     * @param <E>
     * @return
     */
    public static <T, R, E> E  mapper(Map<T, R> map, T t, Function<R, E> function) {
        R r = map.get(t);
        if (null == r) {
            return null;
        }
        return function.apply(r);
    }

    public static void main(String[] args) throws NoSuchFieldException {
        List<Book> bookList = Arrays.asList(new Book(1, "ddd", 12), new Book(2, "dfd", 1));
        Map<Integer, Book> map = bookList.stream().collect(Collectors.toMap(Book::getId, Function.identity()));
        String mapper = mapper(map, 1, Book::getName);
    }
}
