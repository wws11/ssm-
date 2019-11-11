package com.soecode.lyf.book.service;


import com.soecode.lyf.book.pojo.User;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/6/3 8:36
 */
public interface UserService {

    /**根据用户id获取用户
     * @param
     * @return
     * @throws Exception
     * @author weiwensi
     * @date 8:39 2019/6/3
     * @version 2.1
     **/

    User getUserById(String id);
}