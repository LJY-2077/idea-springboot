package com.cn.lijy.service.impl;

import com.cn.lijy.bean.SysMenu;
import com.cn.lijy.mapper.SysMenuMapper;
import com.cn.lijy.service.PortalFolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author lijy
 * @descriptin
 * @since
 */

@Service
public class PortalFolderServiceImpl implements PortalFolderService {
    @Autowired
    SysMenuMapper sysMenuMapper;

    /**
     * 菜单list
     */
    @Override
    public List<SysMenu> getFolderList() {
        List<SysMenu> sysMenus = sysMenuMapper.selectAll();
        return sysMenus;
    }
}
