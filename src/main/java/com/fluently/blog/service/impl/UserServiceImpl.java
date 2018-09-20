package com.fluently.blog.service.impl;

import com.fluently.blog.dao.UserDao;
import com.fluently.blog.model.UserVO;
import com.fluently.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void insertUser(UserVO user) {
        userDao.insertUser(user);
    }
}
