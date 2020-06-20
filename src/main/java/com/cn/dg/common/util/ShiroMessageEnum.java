package com.cn.dg.common.util;


/**
 * @Description: shiro描述枚举
 * @Auther: zcz
 * @create 2020/4/16 11:51
 */
public enum ShiroMessageEnum {
    /**
     * 登录成功！
     */
    SHIRO_AUTHC_LOGIN_MESSAGE("登录成功！"),
    /**
     * 退出成功！
     */
    SHIRO_AUTHC_LOGOUT_MESSAGE("退出成功！"),
    /**
     * 验证码错误！
     */
    SHIRO_CAPTCHA_EXCEPTION_MESSAGE("验证码错误！"),
    /**
     * 认证  账号不存在
     */
    SHIRO_AUTHC_UNKNOWNACCOUNTEXCEPTION_MESSAGE("账号不存在！"),
    /**
     * 认证  密码错误！
     */
    SHIRO_AUTHC_INCORRECTCREDENTIALSEXCEPTION_MESSAGE("密码错误！"),
    /**
     * 认证  密码输入次数超限，请1小时后重试！
     */
    SHIRO_AUTHC_EXCESSIVEATTEMPTSEXCEPTION_MESSAGE("密码输入次数超限，请1小时后重试！"),
    /**
     * 认证  帐号锁定！
     */
    SHIRO_AUTHC_LOCKEDACCOUNTEXCEPTION_MESSAGE("帐号锁定！"),
    /**
     * 认证  用户禁用！
     */
    SHIRO_AUTHC_DISABLEDACCOUNTEXCEPTION_MESSAGE("用户禁用！"),
    /**
     * 认证  不允许多处登录！
     */
    SHIRO_AUTHC_CONCURRENTACCESSEXCEPTION_MESSAGE("不允许多处登录！"),
    /**
     * 认证  过期的凭据！
     */
    SHIRO_AUTHC_EXPIREDCREDENTIALSEXCEPTION_MESSAGE("过期的凭据！"),
    /**
     * 认证  凭据异常！
     */
    SHIRO_AUTHC_CREDENTIALSEXCEPTION_MESSAGE("凭据异常！"),
    /**
     * 认证  登录异常！
     */
    SHIRO_AUTHC_AUTHENTICATIONEXCEPTION_MESSAGE("登录异常！"),
    /**
     * 认证  登录异常！
     */
    SHIRO_AUTHC_ACCOUNTEXCEPTION_MESSAGE("账户异常！"),
    /**
     * 认证  登录异常！
     */
    SHIRO_AUTHC_UNSUPPORTEDTOKENEXCEPTION_MESSAGE("身份令牌异常，不支持的身份令牌！"),
    /**
     * 授权 授权异常！
     */
    SHIRO_AUTHZ_UNAUTHENTICATEDEXCEPTION_MESSAGE("授权异常！"),
    /**
     * 授权 没有访问权限！
     */
    SHIRO_AUTHZ_UNAUTHORIZEDEXCEPTION_MESSAGE("没有访问权限！"),
    /**
     * 授权 授权出现未知异常！
     */
    SHIRO_AUTHZ_AUTHORIZATIONEXCEPTION_MESSAGE("授权出现未知异常！");


    private String msg;

    ShiroMessageEnum(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return this.msg;
    }

}
