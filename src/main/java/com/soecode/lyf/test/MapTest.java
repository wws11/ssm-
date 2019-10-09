package com.soecode.lyf.test;

import com.soecode.lyf.bookuserservice.pojo.Book;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 魏文思
 * @date 2019/9/5$ 11:38$
 */
public class MapTest {


    public static void main(String[] args) throws Exception {
        //枚举可以继承码？
        //接口可以写实现方法吗？
        //接口的默认方法干嘛的？
        //什么时候用继承？
        //内存泄露知道吗？
        //适配器模式
        AAA.BBB.test();
        AAA.CCC.getNum();
        Map<Integer,TreeSet<Book>>  map=new HashMap<>();
        Map<Integer,List<Book>>  map2=new HashMap<>();
        Map<Integer,TreeSet<Book>>  map3=new HashMap<>();
        List<Book> list = Arrays.asList(
                new Book(1,"三国",12)
                ,new  Book(2,"水浒",1)
                ,new  Book(3,"Java++",2)
                ,new  Book(1,"C++",12)
                ,new  Book(2,"java 入门到放弃",3)
                ,new  Book(3,"java入门到走火入魔",6)
                ,new  Book(1,"helloworld",23)
        );

       list.forEach(e->{
         //普通分组
           map2.computeIfAbsent(e.getId(),s -> new ArrayList<>()).add(e);
       });

        //分组并且排序
        //对list里面的数据进行按照id分组，并且按照book的数量进行排序
       list.forEach(book->{
            map.computeIfAbsent(book.getId(),s->new  TreeSet<>((e1,e2)->{
                int flag = e2.getNumber() - e1.getNumber();
                if(flag>0||flag==0){
                    return 1;
                }else  { return -1;}
            })).add(book);
       });
        list.forEach(book->{
            map3.computeIfAbsent(book.getId(),s->new  TreeSet<>(Comparator.comparing(Book::getNumber).reversed())).add(book);
        });
       //stream方式分组
        Map<Integer, List<Book>> collect = list.stream().collect(Collectors.groupingBy(Book::getId));
        //stream方式分组并且排序  默认方式为正序排列
        Map<Integer, List<Book>> streamMap = list.stream().sorted(Comparator.comparingInt(Book::getNumber).reversed()).collect(Collectors.groupingBy(Book::getId));
        System.out.println("不会丢失的treeset "+map);
        System.out.println("stream方式得到map "+streamMap);
        System.out.println("会数据丢失的treeset"+map3);
    }
}
