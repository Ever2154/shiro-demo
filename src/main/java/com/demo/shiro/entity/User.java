package com.demo.shiro.entity;

import lombok.Data;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author huanghao
 * date 2020-11-13
 */
@Data
public class User {
    /**
     * 用户id
     */
    private Long uid;
    /**
     * 登录名，不可改
     */
    private String uname;
    /**
     * 用户昵称，可改
     */
    private String nick;
    /**
     * 已加密的登录密码
     */
    private String pwd;
    /**
     * 加密盐值
     */
    private String salt;
    /**
     * 创建时间
     */
    private Date created;
    /**
     * 修改时间
     */
    private Date updated;
    /**
     * 用户所有角色值，用于shiro做角色权限的判断
     */
    private Set<String> roles = new HashSet<>();
    /**
     * 用户所有权限值，用于shiro做资源权限的判断
     */
    private Set<String> perms = new HashSet<>();
}
