package com.fluently.blog.dao;

import com.fluently.blog.model.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LoginDao {
    public UserVO findUser(@Param("username") String username, @Param("password") String password);
}