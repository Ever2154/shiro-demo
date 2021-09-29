package com.demo.shiro.entity;

import com.demo.shiro.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author huanghao
 * date 2020-11-13
 */
@Slf4j
public class CustomRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        Object principal = principalCollection.getPrimaryPrincipal();
        if(principal==null){
            return null;
        }
        User user = userService.findUserByName(principal.toString());
        SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
        authorizationInfo.addStringPermissions(user.getRoles());
        authorizationInfo.addStringPermissions(user.getPerms());
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        Object principal=authenticationToken.getPrincipal();
        if(authenticationToken.getPrincipal()==null){
            return null;
        }
        User user = userService.findUserByName(principal.toString());
        if(user!=null){
            System.out.println("登录成功");
/*            if(user.getPassword().equals(token.getPassword())){
                log.info("登录成功");
            }else{
                log.error("密码错误");
            }*/
            return new SimpleAuthenticationInfo(principal,authenticationToken.getCredentials(),"123");
        }else{
            log.error("用户不存在");
        }
        return null;
    }
}
