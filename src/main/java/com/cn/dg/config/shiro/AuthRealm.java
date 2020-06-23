package com.cn.dg.config.shiro;

import com.cn.dg.bean.system.*;
import com.cn.dg.mapper.system.DgSysPermissionMapper;
import com.cn.dg.mapper.system.DgSysRolePermissionMapper;
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

import java.util.ArrayList;
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
    private DgSysRolePermissionMapper rolePermissionMapper;
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
        log.info("---------------------开始执行授权----------------------");
        if (null == principals) {
            throw new UnauthenticatedException();
        }
        // 获取安全数据
        //如果身份认证的时候没有传入User对象，这里只能取到userName
        //也就是SimpleAuthenticationInfo构造的时候第一个参数传递需要User对象
        DgSysUser sysUser = (DgSysUser) principals.getPrimaryPrincipal();
        if (Objects.isNull(sysUser)) {
            throw new UnauthenticatedException();
        }
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        DgSysUserRoleExample example = new DgSysUserRoleExample();
        example.createCriteria().andUseridEqualTo(Integer.valueOf(sysUser.getUserid()));
        // 查询用户角色，一个用户可能有多个角色
        List<DgSysUserRole> userRoles = sysUserRoleMapper.selectByExample(example);
        for (DgSysUserRole sysUserRole : userRoles) {
            authorizationInfo.addRole(String.valueOf(sysUserRole.getRoleid()));
            // 根据角色查询权限
            List<DgSysPermission> permissions;
            if ("admin".equals(sysUserRole.getRoleid())) {

                permissions = sysPermissionMapper.selectByExample(null);
            } else {
                DgSysRolePermissionExample example_rp = new DgSysRolePermissionExample();
                example_rp.createCriteria().andRoleidEqualTo(sysUserRole.getRoleid());

                List<DgSysRolePermission> dgSysRolePermissions = rolePermissionMapper.selectByExample(example_rp);
                List<Integer> roleids = new ArrayList<>();
                for (DgSysRolePermission dgSysRolePermission : dgSysRolePermissions) {
                    roleids.add(dgSysRolePermission.getPermissionid());
                }
                DgSysPermissionExample permissionExample = new DgSysPermissionExample();
                permissionExample.createCriteria().andPermissionidIn(roleids);
                permissions = sysPermissionMapper.selectByExample(permissionExample);
            }
            for (DgSysPermission permission : permissions) {
                log.info(permission.getPermissionid().toString());
                authorizationInfo.addStringPermission(permission.getPermission());
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
        log.info("---------------------开始执行认证----------------------");
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String username = usernamePasswordToken.getUsername();
        DgSysUserExample sysUserExample = new DgSysUserExample();
        sysUserExample.createCriteria().andUsernameEqualTo(username);
        List<DgSysUser> dgSysUsers = sysUserMapper.selectByExample(sysUserExample);
        if (Objects.isNull(dgSysUsers)) {
            throw new UnknownAccountException();
        }
        DgSysUser user = dgSysUsers.get(0);
        ByteSource credentialsSalt = ByteSource.Util.bytes(user.getSalt());
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), credentialsSalt, this.getClass().getName());
        SecurityUtils.getSubject().getSession().setAttribute("username", user.getName());
        //会话创建，在线人数加一
        sessionCount.incrementAndGet();
        log.info("---------------------认证结束----------------------");
        return info;
    }

}
