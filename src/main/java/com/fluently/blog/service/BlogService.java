package com.fluently.blog.service;

import com.fluently.blog.model.BlogDetailVO;
import com.fluently.blog.model.BlogVO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface BlogService {
    public void insertBlog(BlogVO blogVO, String userId);

    public List<BlogVO> getAllBlogList();

    public BlogDetailVO getBlogDeitailById(String blogId);

    public BlogVO getOneBlogListById(String blogId);

    public void deleteBlogById(String blogId);

    public void updateBLog(BlogVO blogVO);

    public void addVistorCount(String blogId);

    public List<BlogVO> getMyBlog(HttpServletRequest request);

    public List<BlogVO> getAllPublicBlog();
}
