package com.cn.dg.service.impl;

import com.cn.dg.bean.shiro.CacheUser;
import com.cn.dg.bean.system.DgSysUser;
import com.cn.dg.common.exception.LoginException;
import com.cn.dg.mapper.system.DgSysUserMapper;
import com.cn.dg.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author lijy
 * @descriptin
 * @since
 */
@Slf4j
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    DgSysUserMapper dgSysUserMapper;

    @Override
    public CacheUser login(String userName, String password) {
        // 获取Subject实例对象，用户实例
        Subject subject = SecurityUtils.getSubject();

        // 将用户名和密码封装到UsernamePasswordToken
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);

        CacheUser cacheUser;

        // 4、认证
        try {
            // 传到 MyShiroRealm 类中的方法进行认证
            subject.login(token);
            // 构建缓存用户信息返回给前端
            DgSysUser user = (DgSysUser) subject.getPrincipals().getPrimaryPrincipal();
            cacheUser = CacheUser.builder()
                    .token(subject.getSession().getId().toString())
                    .build();
            BeanUtils.copyProperties(user, cacheUser);
            log.warn("CacheUser is {}", cacheUser.toString());
        } catch (UnknownAccountException e) {
            log.error("账户不存在异常：", e);
            throw new LoginException("账号不存在!", e);
        } catch (IncorrectCredentialsException e) {
            log.error("凭据错误（密码错误）异常：", e);
            throw new LoginException("密码不正确!", e);
        } catch (AuthenticationException e) {
            log.error("身份验证异常:", e);
            throw new LoginException("用户验证失败!", e);
        }
        return cacheUser;
    }
}
