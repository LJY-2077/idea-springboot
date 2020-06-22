package com.cn.dg.service;

import com.cn.dg.bean.system.DgSysMenu;

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
    List<DgSysMenu> getMenuList();
}
