package com.fluently.blog.dao;

import com.fluently.blog.model.BlogVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BlogDao {
    public void insertBlog(BlogVO blogVO);
}
