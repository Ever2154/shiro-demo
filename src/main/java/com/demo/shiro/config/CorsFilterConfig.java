package com.demo.shiro.config;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "MyFilter",urlPatterns = "/*")
//@Configuration
public class CorsFilterConfig implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        //指定允许其他域名访问
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");

        //前端携带cookie时，也就是写了 {withCredentials: true}，后端不能用通配符，
        //得用"Access-Control-Allow-Origin",httpServletRequest.getHeader("origin")

        //响应头设置 Origin, X-Requested-With, Content-Type, Accept
        httpServletResponse.setHeader("Access-Control-Allow-Headers", "*");

        //允许携带cookie
        httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");

        //响应类型
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");

        //option验证后时间
        httpServletResponse.setHeader("Access-Control-Max-Age", "3600");

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}


