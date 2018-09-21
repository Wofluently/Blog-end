package com.fluently.blog.service;

import com.fluently.blog.model.BlogDetailVO;
import com.fluently.blog.model.BlogVO;

import java.util.List;

public interface BlogService {
    public void insertBlog(BlogVO blogVO);

    public List<BlogVO> getAllBlogList();

    public BlogDetailVO getBlogDeitailById(String blogId);
}
