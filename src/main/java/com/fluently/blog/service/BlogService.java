package com.fluently.blog.service;

import com.fluently.blog.model.BlogVO;
import com.fluently.blog.model.CommonResultVO;

public interface BlogService {
    public CommonResultVO insertBlog(BlogVO blogVO);
}
