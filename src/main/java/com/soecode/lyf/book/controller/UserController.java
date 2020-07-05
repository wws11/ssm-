package com.soecode.lyf.book.controller;

import com.soecode.lyf.book.pojo.Book;
import com.soecode.lyf.book.pojo.User;
import com.soecode.lyf.book.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/6/3 8:45
 */
@RestController
@CrossOrigin
@Api(value = "swagger测试测试")
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getUserByid/{id}", method = RequestMethod.GET)
    @ApiOperation(notes = "根于用户id获取用户",value = "根据用户id获取用户",produces = MediaType.APPLICATION_JSON_VALUE)
    private User getUserById(@PathVariable  String  id) throws IOException {
        User user = userService.getUserById(id);
        return user;
    }


    public static void main(String[] args) {
        List<Book> books = Arrays.asList(new Book(123,"sdf",12),new Book(1,"sdf]",12),new Book(3,"sdf",12),new Book(1,"fhghdf]",15),new Book(2,"hghhfgh",12));
     /*   LinkedHashMap<Integer, String> map = books.stream().collect(Collectors.toMap(Book::getId, Book::getName, (oldValue, newValue) -> oldValue,
                LinkedHashMap::new));
        Map<Long, String> map = books.stream().collect(Collectors.toMap(Book::getId, Book::getName, (oldValue, newValue) -> oldValue,
                LinkedHashMap::new));
        //遍历
        for(Map.Entry<Long,String> entry:map.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
        //利用jdk8进行统list里面的的数据统计   使用对象作为key必须重写hashcode和equals方法，不然对象不能相等，不归为一类
        Map<Book, Long> collect = books.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        for(Map.Entry<Book,Long> entry:collect.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
        //List<String> name = new ArrayList<>(Arrays.asList("xxx","yyy","zzz"))；


        //测试linkhashmap的有序性
        System.out.println("测试map排序特性-----------------------------------------》");
        List<String> strList = Arrays.asList("aa", "bb", "哈哈", "撸啊撸", "小小", "阿欧元");
        Map<String, Long> strCountMap = strList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("没有排序之前的数据");
            System.out.println(strCountMap);
        //排序以后
        Map<String ,Long> finaMap=new LinkedHashMap<>();
        strCountMap.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue()
                .reversed()).forEachOrdered(e->finaMap.put(e.getKey(),e.getValue()));
        System.out.println(finaMap);

        System.out.println("经过groupby排序前");
        Map<Long, List<Book>> bookMap = books.stream().collect(Collectors.groupingBy(Book::getId));
        System.out.println(bookMap);
        System.out.println("数据处理以后排序之后");
        //对group之后对象中某个重复的字段进行去重
        Map<Long, Set<String>> result = books.stream().collect(Collectors.groupingBy(Book::getId, Collectors.mapping(Book::getName, Collectors.toSet())));
        System.out.println("对group之后对象中某个重复的字段进行去重   result"+result);
        //只取groupby以后对象里面的对象某个属性的集合
        Map<Long, List<String>> attrMap = books.stream().collect(Collectors.groupingBy(Book::getId, Collectors.mapping(Book::getName, Collectors.toList())));
        System.out.println("attrMap只取groupby以后对象里面的对象某个属性的集合"+attrMap);
        Map<Long, Map<String, Integer>> groupMap = books.stream().collect(Collectors.groupingBy(Book::getId, Collectors.toMap(Book::getName, Book::getNumber)));
        System.out.println("经过分组再对分组里的数据进行map的转换");
        System.out.println(groupMap);
*/



        List<Book> linkList=new LinkedList<>();
        System.out.println("array list顺序");
        books.forEach(e->{
            linkList.add(e);
            System.out.println(e);
        });
        System.out.println("linklist 顺序");
        linkList.forEach(e->{
            System.out.println(e);
        });

    }

    public  void test(){
//sdkfhkshjkfjk
    }

    public   void  test222(){
//shfuiehwohfiewhohoe
    }
}
