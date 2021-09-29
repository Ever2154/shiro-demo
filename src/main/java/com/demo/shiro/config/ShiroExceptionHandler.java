package com.demo.shiro.config;

import com.demo.shiro.vo.ResponseCode;
import com.demo.shiro.vo.ApiResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName ShiroExceptionHandler
 * @Description
 * @Author 黄皓
 * @Date 2020/11/15 22:43
 **/
@ControllerAdvice
@Slf4j
public class ShiroExceptionHandler {

    
    /**
     * @description: 未授权
     * @return: 
     * @author: 黄皓
     * @time: 2020/11/15 22:53
     */
    @ExceptionHandler(AuthorizationException.class)
    @ResponseBody
    public ApiResult authoHandler(AuthorizationException e) {
        if(e instanceof UnauthorizedException){
            System.out.println("123");
        }
        log.error("没有通过权限验证！");
        return ApiResult.errorResponse(ResponseCode.NO_AUTHORIZATION.getCode(),ResponseCode.NO_AUTHORIZATION.getMsg());
    }
}
