package com.fluently.blog.service;

import com.fluently.blog.model.UserVO;

public interface LoginService {

    public UserVO findUser(String username, String password);

    public void addUser(UserVO userVO);
}
