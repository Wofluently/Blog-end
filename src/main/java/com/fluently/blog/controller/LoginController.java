package com.fluently.blog.controller;

import com.fluently.blog.model.UserVO;
import com.fluently.blog.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/blog")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Boolean login(HttpServletRequest request, HttpServletResponse response, @RequestParam("username") String username, @RequestParam("password") String password) {
        UserVO userVO = loginService.findUser(username, password);

        if (userVO != null) {
            //使用request对象的getSession()获取session，如果session不存在则创建一个
            HttpSession session = request.getSession();
            //将数据存储到session中
            session.setAttribute("username", userVO.getUsername());
            session.setAttribute("id", userVO.getId());
            session.setMaxInactiveInterval(60 * 20); //单位秒
            return true;
        } else {
            return false;
        }


    }
}
