package com.demo.shiro.controller;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName BaseController
 * @Description
 * @Author 黄皓
 * @Date 2021/9/26 20:48
 **/
public class BaseController {
    @GetMapping("/test")
    @RequiresRoles("123")
    public String test(){
        return "";
    }
}
