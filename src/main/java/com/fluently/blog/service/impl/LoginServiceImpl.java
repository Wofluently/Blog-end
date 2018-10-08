package com.fluently.blog.service.impl;

import com.fluently.blog.dao.LoginDao;
import com.fluently.blog.model.UserVO;
import com.fluently.blog.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginDao loginDao;

    @Override
    public UserVO findUser(String username, String password) {
        return loginDao.findUser(username, password);
    }
}
