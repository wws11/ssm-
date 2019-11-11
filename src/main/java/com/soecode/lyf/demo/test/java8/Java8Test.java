package com.soecode.lyf.demo.test.java8;

import com.soecode.lyf.book.pojo.Book;

import java.util.function.Predicate;

/**
 * @author 魏文思
 * @date 2019/11/8$ 17:48$
 */
public class Java8Test<T> {
    public static void main(String[] args) {
        /*int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        List<Integer> list = new ArrayList<>();
        for (int i : numbers) {
            list.add(i);
        }
        Predicate<Integer> p1 = i -> i > 5;

        System.out.println("Pricicate :" + p1.test(6));
        Predicate<Integer> p2 = i -> i < 20;
        Predicate<Integer> p3 = i -> i % 2 == 0;
        List test = list.stream().filter(p1.and(p2).and(p3)).collect(Collectors.toList());
        System.out.println(test.toString());*/
        Book book =new Book();
        book.setNumber(100);
        boolean result = testPredic(e -> e.getNumber() > 10,book);
        System.out.println(result);
    }

    public static boolean testPredic(Predicate<Book> bookPredicate, Book book) {
       return bookPredicate.test(book);
    }



}
