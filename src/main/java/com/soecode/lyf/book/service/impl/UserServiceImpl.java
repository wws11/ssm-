package com.soecode.lyf.book.service.impl;

import com.soecode.lyf.book.dao.AccountDao;
import com.soecode.lyf.book.pojo.User;
import com.soecode.lyf.book.service.UserService;
import com.soecode.lyf.datasource.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/6/3 8:36
 */
@Service
public class UserServiceImpl   implements UserService {

    @Autowired
    private AccountDao accountDao;

    @Override
    @DataSource("dataSource1")
    public User getUserById(String id) {
        return accountDao.getUserById(id);
    }
}
