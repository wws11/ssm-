package com.soecode.lyf.bookuserservice.controller;

import com.alibaba.fastjson.JSONObject;
import com.soecode.lyf.bookuserservice.pojo.Book;
import com.soecode.lyf.bookuserservice.service.BookService;
import com.soecode.lyf.exception.ParamInvalidException;
import com.soecode.lyf.tools.zk.HttpClientUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/7/18 12:15
 */


@RestController
@CrossOrigin
@Api(value = "swagger测试测试")
@RequestMapping("/book")
@Slf4j
public class BookController {

    private final static Logger logger = LoggerFactory.getLogger(BookController.class);
    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ApiOperation(notes = "获取所有的书", value = "获取所有的书", produces = MediaType.APPLICATION_JSON_VALUE)
    private List<Book> list() throws ParamInvalidException {
        try {
            JSONObject jsonObject = HttpClientUtils.httpGet("http://192.168.3.227:8080/cas-client/restlogin/getSysTemUrl");
            System.out.println(jsonObject.toJSONString());
            List<Book> list = bookService.getList();
            return list;
        } catch (Exception e) {
            log.error("查找错误", e);
            throw e;
        }
    }

    @GetMapping(value = "/detail/{bookId}/{userName}")
    @ApiOperation(value = "根据书的id获取书的详情", notes = "根据书的id获取书的详情", produces = MediaType.APPLICATION_JSON_VALUE)
    private Book detail(@PathVariable("bookId") Long bookId, @PathVariable("userName") String userName) {
        Book book = bookService.getById(bookId, userName);
        return book;
    }


    public static String buildSuccessResultStr(Object result) {
        if (null == result) {
            return "{\"msg\": \"success\",\"code\": " + 200 + ",\"result\":  " + result + "}";
        }
        return "{\"msg\": \"success\",\"code\": " + 200 + ",\"result\": \"" + result.toString().replaceAll("\"", "\\\"") + "\"}";
    }


    @GetMapping(value = "/test")
    @ApiOperation(value = "ceshi", notes = "测试", produces = MediaType.APPLICATION_JSON_VALUE)
    public void test() throws Exception {
    /*
        String ss = "\"sadas\"";
        String  str="fdgdgdr";
        String s = buildSuccessResultStr(str.replaceAll("\"", "\\\\\""));
        System.out.println(s);*/

        try {
            // 这种异常处理方式 前端也会接受到，日志也会打印
            // bookService.testException();
        } catch (Exception e) {
            logger.error("test error  }", e);
            throw e;
        }

    }

    @GetMapping(value = "/batchSaveBook")
    @ApiOperation(value = "批量插入50万条数据", notes = "批量插入50万条数据", produces = MediaType.APPLICATION_JSON_VALUE)
    public void batchSaveBook() {
        try {
            bookService.batchSaveBook();
        } catch (Exception e) {
            logger.error("batchSaveBook error  }", e);
            throw e;
        }

    }

    @PostMapping(value = "/testStr")
    @ResponseBody
    @ApiOperation(value = "测试特殊字符处理", notes = "测试特殊字符处理", produces = MediaType.APPLICATION_JSON_VALUE)
    public String testStr(@RequestBody AddPararm addPararm) {
        try {
            return "ok";
        } catch (Exception e) {
            logger.error("checkConcealDeal error  addPararm={}", e);
            throw e;
        }
    }

    @GetMapping("/hello")
    @ApiOperation(value = "测试特殊字符处理ssss", notes = "测试特殊字符处理sss", produces = MediaType.APPLICATION_JSON_VALUE)
    public String hello() {
        System.out.println("hello");
        return "ok";
    }

}
