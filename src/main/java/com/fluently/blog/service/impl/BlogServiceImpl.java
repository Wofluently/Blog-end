package com.fluently.blog.service.impl;

import com.fluently.blog.dao.BlogDao;
import com.fluently.blog.model.BlogVO;
import com.fluently.blog.model.CommonResultVO;
import com.fluently.blog.service.BlogService;
import com.fluently.blog.utils.CommonResult;
import com.fluently.blog.utils.RandomUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogDao blogDao;

    @Autowired
    private RandomUUID randomUUID;

    @Autowired
    private CommonResultVO commonResultVO;

    @Autowired
    private CommonResult commonResult;

    @Override
    public CommonResultVO insertBlog(BlogVO blogVO) {
        Date date = new Date();
        blogVO.setId(randomUUID.createUUID());
        blogVO.setTime(date.toString());
        try {
            blogDao.insertBlog(blogVO);
            return commonResult.reqSuccess("");
        } catch (Exception e) {
            return commonResult.reqError(e.toString());
        }
    }
}
