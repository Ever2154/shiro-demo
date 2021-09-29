package com.demo.shiro.controller;

import com.demo.shiro.entity.User;
import com.demo.shiro.vo.ApiResult;
import com.demo.shiro.vo.ResponseCode;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @author huanghao
 * date 2020-11-13
 */
@RestController
public class LoginController extends BaseController{
    {
        System.out.println("加载...");
    }
    @GetMapping("/login")
    public String login(User user){
        Subject subject =SecurityUtils.getSubject();
        subject.login(new UsernamePasswordToken(user.getUname(),user.getPwd()));
        return "200";
    }

    //@RequiresRoles("系统管理")
    @GetMapping("/admin")
    public ApiResult admin() throws Exception {
        System.out.println("系统管理员界面");
        return ApiResult.successResponse();
    }

    @GetMapping("/loginOut")
    public String loginOut()  {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        System.out.println("退出登录。。。");
        return "退出成功";
    }

    /**
     * @description: 未授权
     * @return:
     * @author: 黄皓
     * @time: 2020/11/15 22:53
     */
    @GetMapping("/unauthorized")
    public ApiResult unauthorized(HttpServletResponse response) {
        //防止跨域
        response.setHeader("Access-Control-Allow-Origin", "*");
        System.out.println("进入unauthorized");
        return ApiResult.errorResponse(ResponseCode.NO_AUTHORIZATION.getCode(),ResponseCode.NO_AUTHORIZATION.getMsg());
    }

    @Override
    public String test(){
        System.out.println("test");
        return "test";
    }
}
