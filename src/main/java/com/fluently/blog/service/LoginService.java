package com.fluently.blog.service;

import com.fluently.blog.model.UserVO;

import javax.servlet.http.HttpServletRequest;

public interface LoginService {
    public void setSession(HttpServletRequest req, UserVO userVO);

    public UserVO findUser(String username, String password);

    public void addUser(UserVO userVO);

    public UserVO getCurrentUser(HttpServletRequest request);
}
