package com.cn.dg.common.util;


import org.apache.shiro.crypto.hash.SimpleHash;

import java.util.UUID;

/**
 * @Description: 加密工具类
 * @Auther: zcz
 * @create 2020/4/16 11:51
 */
public class ShiroUtil {

    /**
     * 生成32的随机盐值
     */
    public static String createSalt() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 加盐加密
     *
     * @param srcPwd    原始密码
     * @param saltValue 盐值
     */
    public static String createPassWord(Object srcPwd, String saltValue) {
        return new SimpleHash("MD5", srcPwd, saltValue, 10).toString();
    }

}
