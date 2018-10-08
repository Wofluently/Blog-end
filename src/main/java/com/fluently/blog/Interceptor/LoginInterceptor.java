package com.fluently.blog.Interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object obj, Exception err)
            throws Exception {
        System.out.println("============================拦截器关闭==============================");
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object obj, ModelAndView mav) throws Exception {
        System.out.println("============================执行处理完毕==============================");
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object obj) throws Exception {
        System.out.println("============================拦截器启动==============================");
        //获取session里的登录状态值
        String username = (String) request.getSession().getAttribute("username");
        String userid = (String) request.getSession().getAttribute("id");
        System.out.println(username);
        System.out.println(userid);
        //如果登录状态不为空则返回true，返回true则会执行相应controller的方法
        if (username != null && userid != null) {
            return true;
        }
        //如果登录状态为空则重定向到登录页面，并返回false，不执行原来controller的方法
        response.setStatus(333);
        return false;
    }

}



