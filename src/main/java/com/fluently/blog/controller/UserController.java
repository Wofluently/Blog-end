package com.fluently.blog.controller;

import com.fluently.blog.model.UserVO;
import com.fluently.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "Hello Spring";
    }

    @RequestMapping(value = "/insertUser", method = RequestMethod.POST)
    public void insertUser(@RequestParam("name") String name, @RequestParam("sex") String sex) {
        UserVO user = new UserVO();
        user.setName(name);
        user.setSex(sex);
        userService.insertUser(user);
    }
}
