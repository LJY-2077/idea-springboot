package com.cn.dg.service.impl;

import com.cn.dg.bean.system.DgSysMenu;
import com.cn.dg.mapper.system.DgSysMenuMapper;
import com.cn.dg.service.SystemMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lijy
 * @descriptin
 * @since
 */

@Service
public class SystemMenuServiceImpl implements SystemMenuService {
    @Autowired
    DgSysMenuMapper sysMenuMapper;

    /**
     * 菜单list
     */
    @Override
    public List<DgSysMenu> getFolderList() {
        List<DgSysMenu> sysMenus = sysMenuMapper.selectByExample(null);
        return sysMenus;
    }
}
