package com.demo.shiro.entity;

import lombok.Data;

import java.util.Set;

/**
 * @author huanghao
 * date 2020-11-13
 */
@Data
public class Role {
    private String id;
    private String roleName;
    private Set<Permission> permissions;
}
