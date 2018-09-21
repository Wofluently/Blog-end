package com.fluently.blog.service.impl;

import com.fluently.blog.dao.BlogDao;
import com.fluently.blog.model.BlogDetailVO;
import com.fluently.blog.model.BlogVO;
import com.fluently.blog.service.BlogService;
import com.fluently.blog.utils.RandomUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogDao blogDao;

    @Autowired
    private RandomUUID randomUUID;

    @Override
    public void insertBlog(BlogVO blogVO) {
        String blogId = randomUUID.createUUID();
        String blogDetailId = randomUUID.createUUID();

        blogVO.setId(blogId);
        blogVO.setTime(new Timestamp(System.currentTimeMillis()));

        BlogDetailVO blogDetailVO = new BlogDetailVO();
        blogDetailVO.setId(blogDetailId);
        blogDetailVO.setBlog_id(blogId);
        blogDetailVO.setContent(blogVO.getContent());

        blogDao.insertBlog(blogVO);
        blogDao.insertBlogDetail(blogDetailVO);
    }

    @Override
    public List<BlogVO> getAllBlogList() {
        return blogDao.getAllBlogList();
    }

    @Override
    public BlogDetailVO getBlogDeitailById(String blogId) {
        return blogDao.getBlogDeitailById(blogId);
    }
}
