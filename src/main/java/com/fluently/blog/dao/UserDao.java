package com.fluently.blog.dao;

import com.fluently.blog.model.UserVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    public void insertUser(UserVO user);
}