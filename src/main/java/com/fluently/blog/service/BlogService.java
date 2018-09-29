package com.fluently.blog.service;

import com.fluently.blog.model.BlogDetailVO;
import com.fluently.blog.model.BlogVO;

import java.util.List;

public interface BlogService {
    public void insertBlog(BlogVO blogVO);

    public List<BlogVO> getAllBlogList();

    public BlogDetailVO getBlogDeitailById(String blogId);

    public BlogVO getOneBlogListById(String blogId);

    public void deleteBlogById(String blogId);

    public void updateBLog(BlogVO blogVO);

    public void addVistorCount(String blogId);
}
