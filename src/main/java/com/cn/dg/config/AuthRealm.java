package com.cn.dg.config;

import com.cn.dg.bean.system.*;
import com.cn.dg.mapper.system.DgSysPermissionMapper;
import com.cn.dg.mapper.system.DgSysUserMapper;
import com.cn.dg.mapper.system.DgSysUserRoleMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description: AuthRealm
 * @Auther: zcz
 * @create 2020/4/16 11:51
 */
@Slf4j
public class AuthRealm extends AuthorizingRealm {
    @Autowired
    private DgSysUserRoleMapper sysUserRoleMapper;
    @Autowired
    private DgSysPermissionMapper sysPermissionMapper;
    @Autowired
    private DgSysUserMapper sysUserMapper;
    /**
     * 统计在线人数
     * juc包下线程安全自增
     */
    public static final AtomicInteger sessionCount = new AtomicInteger(0);

    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        log.info("---------------------授权----------------------");
        if (null == principals) {
            throw new UnauthenticatedException();
        }
        // 获取安全数据
        DgSysUser sysUser = (DgSysUser) principals.getPrimaryPrincipal();
        if (Objects.isNull(sysUser)) {
            throw new UnauthenticatedException();
        }
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        DgSysUserRoleExample example = new DgSysUserRoleExample();
        example.createCriteria().andUseridEqualTo(Integer.valueOf(sysUser.getUserid()));
        List<DgSysUserRole> userRoles = sysUserRoleMapper.selectByExample(example);
        for (DgSysUserRole sysUserRole : userRoles) {
            authorizationInfo.addRole(String.valueOf(sysUserRole.getRoleid()));
            List<DgSysPermission> permissions;
            if ("admin".equals(sysUserRole.getRoleid())) {

                permissions = sysPermissionMapper.selectByExample(null);
            } else {
                DgSysPermissionExample permissionExample = new DgSysPermissionExample();
                permissionExample.createCriteria().andParentidEqualTo(Long.valueOf(sysUserRole.getRoleid()));

                permissions = sysPermissionMapper.selectByExample(permissionExample);
            }
            for (DgSysPermission permission : permissions) {
                log.info(permission.getPermissionid().toString());
                authorizationInfo.addStringPermission(permission.getPermissionid().toString());
            }
        }
        log.info("---------------------授权结束----------------------");
        return authorizationInfo;
    }

    /**
     * 认证
     *
     * @param token
     * @return
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) {
        log.info("---------------------认证----------------------");
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String username = usernamePasswordToken.getUsername();
        DgSysUserExample sysUserExample=new DgSysUserExample();
        sysUserExample.createCriteria().andUsernameEqualTo(username);
        List<DgSysUser> dgSysUsers = sysUserMapper.selectByExample(sysUserExample);
        if (Objects.isNull(dgSysUsers)) {
            throw new UnknownAccountException();
        }
        DgSysUser user=dgSysUsers.get(0);
        ByteSource credentialsSalt = ByteSource.Util.bytes(user.getSalt());
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), credentialsSalt, this.getClass().getName());
        SecurityUtils.getSubject().getSession().setAttribute("username", user.getName());
        //会话创建，在线人数加一
        sessionCount.incrementAndGet();
        log.info("---------------------认证结束----------------------");
        return info;
    }

}
