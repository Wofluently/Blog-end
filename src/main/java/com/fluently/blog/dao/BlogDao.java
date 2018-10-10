package com.fluently.blog.dao;

import com.fluently.blog.model.BlogDetailVO;
import com.fluently.blog.model.BlogVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BlogDao {
    public void insertBlog(BlogVO blogVO);

    public void insertBlogDetail(BlogDetailVO blogDetailVO);

    public List<BlogVO> getAllBlogList();

    public BlogDetailVO getBlogDeitailById(@Param("blogId") String blogId);

    public BlogVO getOneBlogListById(@Param("blogId") String blogId);

    public void deleteBlogById(@Param("blogId") String blogId);

    public void deleteBlogDetailById(@Param("blogId") String blogId);

    public void updateBlog(BlogVO blogDetailVO);

    public void updateBlogDetail(BlogVO blogDetailVO);

    public void addVistorCount(@Param("blogId") String blogId, @Param("count") Integer count);

    public List<BlogVO> getMyBlog(@Param("userId") String userId);

    public List<BlogVO> getAllPublicBlog();
}
