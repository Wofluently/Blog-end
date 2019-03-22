package com.fluently.blog.service.impl;

import com.fluently.blog.dao.LoginDao;
import com.fluently.blog.model.UserVO;
import com.fluently.blog.service.LoginService;
import com.fluently.blog.utils.RandomUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginDao loginDao;

    @Autowired
    private RandomUUID randomUUID;

    @Override
    public String setSession(HttpServletRequest req, UserVO userVO) {
        //使用request对象的getSession()获取session，如果session不存在则创建一个
        HttpSession session = req.getSession();
        //将数据存储到session中
        session.setAttribute("username", userVO.getUsername());
        session.setAttribute("id", userVO.getId());
        session.setMaxInactiveInterval(60 * 20); //单位秒
        return session.getId();
    }

    @Override
    public UserVO findUser(String username, String password) {
        return loginDao.findUser(username, password);
    }

    @Override
    public void addUser(UserVO userVO) {
        userVO.setId(randomUUID.createUUID());
        loginDao.addUser(userVO);
    }

    @Override
    public UserVO getCurrentUser(HttpServletRequest request) {
        String userId = (String) request.getSession().getAttribute("id");
        return loginDao.getCurrentUser(userId);
    }
}
