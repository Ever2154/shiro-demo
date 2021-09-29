package com.demo.shiro.vo;

/**
 * @description: 响应码枚举类
 * @return:
 * @author: 黄皓
 * @time: 2020/11/15 22:51
 */
public enum ResponseCode {

    /**
     * @description: 未授权
     * @return:
     * @author: 黄皓
     * @time: 2020/11/15 22:52
     */
    NO_AUTHORIZATION(403,"未授权");
    String msg;
    int code;
    ResponseCode(int code,String msg){
        this.msg=msg;
        this.code=code;
    }

    public int getCode() {
        return code;
    }
    public String getMsg() {
        return msg;
    }
}
