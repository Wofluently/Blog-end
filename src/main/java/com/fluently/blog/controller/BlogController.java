package com.fluently.blog.controller;

import com.fluently.blog.model.BlogVO;
import com.fluently.blog.model.CommonResultVO;
import com.fluently.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @RequestMapping(value = "/insertBlog", method = RequestMethod.POST)
    public CommonResultVO insertBlog(@RequestBody BlogVO blogVO) {
        return blogService.insertBlog(blogVO);
    }
}
