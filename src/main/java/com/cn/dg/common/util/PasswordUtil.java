package com.cn.dg.common.util;

import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * @author lijy
 * @descriptin
 * @since
 */
public class PasswordUtil {
    /**
     * 测试非可逆加密算法
     */
    public static void main(String[] args) {
        String str = "123456";
//第一个参数代表加密使用的算法 第二个参数要加密的字符串 第三个参数 加入的盐的值 第四个参数 hash迭代的次数
//以后再保存用户的密码应该使用加密算法加密
        SimpleHash simpleHash = new SimpleHash("md5", str, "123", 10);
        String code = simpleHash.toString();
        System.out.println("加密后的密文:" + code);
    }
}
