package com.cn.dg.config.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import java.util.Objects;

/**
 * @Description: 密码验证
 * @Auther: zcz
 * @create 2020/4/16 11:51
 */
public class CredentialMatcher extends SimpleCredentialsMatcher {

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        UsernamePasswordToken utoken = (UsernamePasswordToken) token;
        //获得用户输入的密码
        String inPassword = new String(utoken.getPassword());
        //获得数据库中的密码
        String dbPassword = (String) info.getCredentials();
        ByteSource salt = ((SimpleAuthenticationInfo) info).getCredentialsSalt();
        //将用户输入的密码加盐散列10次
        inPassword = new SimpleHash("md5", inPassword, salt, 10).toString();
        //进行密码的比对
        boolean flag = Objects.equals(inPassword, dbPassword);
        return flag;
    }
}
