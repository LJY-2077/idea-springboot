package com.cn.dg.service;

import com.cn.dg.bean.shiro.CacheUser;

/**
 * @author lijy
 * @descriptin
 * @since
 */
public interface IUserService {

    CacheUser login(String userName, String password);
}
