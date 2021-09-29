package com.demo.shiro.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @ClassName ApiResult
 * @Description
 * @Author 黄皓
 * @Date 2020/11/14 19:49
 **/
@Data
public class ApiResult<T> {
    int code;
    String msg;
    T data;

    public ApiResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static ApiResult errorResponse(int code, String msg ){
        return new ApiResult(code,msg);
    }
    public static ApiResult successResponse(){
        return new ApiResult(200,"操作成功");
    }
}
