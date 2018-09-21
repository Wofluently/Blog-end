package com.fluently.blog.utils;

import com.fluently.blog.model.CommonResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommonResult {

    @Autowired
    private CommonResultVO commonResultVO;

    public CommonResultVO reqSuccess(String data) {
        commonResultVO.setStatus("200");
        commonResultVO.setMessage("");
        commonResultVO.setData(data);
        return commonResultVO;
    }

    public CommonResultVO reqError(String data) {
        commonResultVO.setStatus("404");
        commonResultVO.setMessage("服务器开小差了");
        commonResultVO.setData(data);
        return commonResultVO;
    }
}
