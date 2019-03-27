package com.fluently.blog.service.impl;

import com.fluently.blog.dao.BlogDao;
import com.fluently.blog.model.BlogDetailVO;
import com.fluently.blog.model.BlogVO;
import com.fluently.blog.model.PageBean;
import com.fluently.blog.service.BlogService;
import com.fluently.blog.utils.RandomUUID;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogDao blogDao;

    @Autowired
    private RandomUUID randomUUID;

    @Override
    public void insertBlog(BlogVO blogVO, String userId) {
        String blogId = randomUUID.createUUID();
        String blogDetailId = randomUUID.createUUID();

        blogVO.setId(blogId);
        blogVO.setTime(System.currentTimeMillis());
        blogVO.setOwner(userId);

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

    @Override
    public BlogVO getOneBlogListById(String blogId) {
        return blogDao.getOneBlogListById(blogId);
    }

    @Override
    public void deleteBlogById(String blogId) {
        blogDao.deleteBlogById(blogId);
        blogDao.deleteBlogDetailById(blogId);
    }

    @Override
    public void updateBLog(BlogVO blogVO) {
        blogVO.setTime(System.currentTimeMillis());
        blogDao.updateBlog(blogVO);
        blogDao.updateBlogDetail(blogVO);
    }

    @Override
    public void addVistorCount(String blogId) {
        BlogVO blogVO = blogDao.getOneBlogListById(blogId);
        int count = blogVO.getVistor_count();
        blogDao.addVistorCount(blogId, ++count);
    }

    @Override
    public PageInfo<BlogVO> getMyBlog(HttpServletRequest request, PageBean pageBean) {
        String userId = (String) request.getSession().getAttribute("id");
        PageHelper.startPage(pageBean.getPageNum(), pageBean.getPageSize());
        List<BlogVO> blogList = blogDao.getMyBlog(userId);
        PageInfo<BlogVO> pageInfo = new PageInfo<BlogVO>(blogList);
        return pageInfo;
    }

    @Override
    public PageInfo<BlogVO> getAllPublicBlog(PageBean pageBean) {
        PageHelper.startPage(pageBean.getPageNum(), pageBean.getPageSize());
        List<BlogVO> blogList = blogDao.getAllPublicBlog();
        PageInfo<BlogVO> pageInfo = new PageInfo<BlogVO>(blogList);
        return pageInfo;
    }
}
