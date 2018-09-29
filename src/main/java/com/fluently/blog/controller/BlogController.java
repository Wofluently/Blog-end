package com.fluently.blog.controller;

import com.fluently.blog.model.BlogDetailVO;
import com.fluently.blog.model.BlogVO;
import com.fluently.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @RequestMapping(value = "/insertBlog", method = RequestMethod.POST)
    public void insertBlog(@RequestBody BlogVO blogVO) {
        blogService.insertBlog(blogVO);
    }

    @RequestMapping(value = "/getAllBlogList", method = RequestMethod.POST)
    public List<BlogVO> getAllBlogList() {
        return blogService.getAllBlogList();
    }

    @RequestMapping(value = "/getBlogDeitailById", method = RequestMethod.POST)
    public BlogDetailVO getBlogDeitailById(@RequestParam("blogId") String blogId) {
        return blogService.getBlogDeitailById(blogId);
    }

    @RequestMapping(value = "/getOneBlogListById", method = RequestMethod.POST)
    public BlogVO getOneBlogListById(@RequestParam("blogId") String blogId) {
        return blogService.getOneBlogListById(blogId);
    }

    @RequestMapping(value = "/deleteBlogById", method = RequestMethod.POST)
    public void deleteBlogById(@RequestParam("blogId") String blogId) {
        blogService.deleteBlogById(blogId);
    }

    @RequestMapping(value = "/updateBlog", method = RequestMethod.POST)
    public void updateBlog(@RequestBody BlogVO blogVO) {
        blogService.updateBLog(blogVO);
    }

    @RequestMapping(value = "/addVistorCount", method = RequestMethod.POST)
    public void addVistorCount(@RequestParam("blogId") String blogId) {
        blogService.addVistorCount(blogId);
    }
}
