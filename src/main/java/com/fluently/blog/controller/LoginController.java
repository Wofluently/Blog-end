package com.fluently.blog.controller;

import com.fluently.blog.model.UserVO;
import com.fluently.blog.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/blog")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, HttpServletResponse response, @RequestParam("username") String username, @RequestParam("password") String password) {
        UserVO userVO = loginService.findUser(username, password);
        if (userVO != null) {
            return loginService.setSession(request, userVO);
        } else {
            return "";
        }
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public void addUser(@RequestBody UserVO userVO) {
        loginService.addUser(userVO);
    }

    @RequestMapping(value = "/curUserInfo", method = RequestMethod.POST)
    public UserVO userInfo(HttpServletRequest request) {
        return loginService.getCurrentUser(request);
    }

    @RequestMapping(value = "/isSession", method = RequestMethod.GET)
    public void isSession() {
    }
}
