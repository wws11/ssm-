package com.soecode.lyf.bookuserservice.service.impl;

import com.soecode.lyf.bookuserservice.dao.AccountDao;
import com.soecode.lyf.bookuserservice.pojo.User;
import com.soecode.lyf.bookuserservice.service.UserService;
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
    @DataSource("dataSource2")
    public User getUserById(String id) {
        return accountDao.getUserById(id);
    }
}
