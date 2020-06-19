package com.cn.lijy.service;

import com.cn.lijy.bean.SysMenu;

import java.util.List;

/**
 * @author lijy
 * @descriptin
 * @since
 */
public interface SystemMenuService {

    /**
     * 菜单list
     */
    List<SysMenu> getFolderList();
}
