package com.soecode.lyf.bookuserservice.controller;

import com.soecode.lyf.bookuserservice.pojo.User;
import com.soecode.lyf.bookuserservice.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


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
    private User getUserById(@PathVariable  String  id) {
        User user = userService.getUserById(id);
        return user;

    }
}
