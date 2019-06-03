package com.soecode.lyf.service.impl;

import com.soecode.lyf.dao.AccountDao;
import com.soecode.lyf.data.DataSource;
import com.soecode.lyf.entity.User;
import com.soecode.lyf.service.UserService;
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
    private AccountDao  accountDao;

    @Override
    @DataSource("dataSource2")
    public User getUserById(String id) {
        return accountDao.getUserById(id);
    }
}
