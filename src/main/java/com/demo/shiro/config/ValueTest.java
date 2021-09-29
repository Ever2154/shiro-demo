package com.demo.shiro.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @ClassName ValueTest
 * @Description
 * @Author 黄皓
 * @Date 2021/9/24 17:57
 **/
@Component
public class ValueTest implements InitializingBean {
    @Value("#{@environment['shiro.loginUrl'] ?: '/login.jsp' }")
    public String loginUrl;


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(loginUrl);
    }
}
