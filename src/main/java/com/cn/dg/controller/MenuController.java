package com.cn.dg.controller;

import com.cn.dg.bean.system.DgSysMenu;
import com.cn.dg.bean.system.DgSysRolePermission;
import com.cn.dg.bean.system.DgSysRolePermissionExample;
import com.cn.dg.mapper.system.DgSysMenuMapper;
import com.cn.dg.mapper.system.DgSysRolePermissionMapper;
import com.cn.dg.service.SystemMenuService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lijy
 * @descriptin 菜单数据管理
 * @since
 */
@RestController
public class MenuController {
    @Autowired
    SystemMenuService menuService;
    @Autowired
    DgSysRolePermissionMapper permissionMapper;
    @Autowired
    DgSysMenuMapper menuMapper;


    @RequestMapping(value = "/currentFolderList")
    @ResponseBody
    public String menuData(String currentpageId, ModelMap model) {
        //获取所有的节点列表
        List<DgSysMenu> folderList = menuService.getMenuList();
        //封装成json格式,我引入的是import net.sf.json.JSONArray;
        JSONArray jsonArray = JSONArray.fromObject(folderList);
        //将json转成字符串
        String json = jsonArray.toString();
        return json;
    }


    public List<Map<String, Object>> menuData(Integer roleId) {
        //封装所有数据
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        //获取到 当前角色下的 菜单id
        List<DgSysRolePermission> list1;
        if (roleId == null || roleId == -1) {
            list1 = new ArrayList<>();
        } else {
            DgSysRolePermissionExample example = new DgSysRolePermissionExample();
            example.createCriteria().andRoleidGreaterThan(roleId);
            list1 = permissionMapper.selectByExample(example);
        }
        //查询二级 和一下的菜单封装
        List<DgSysMenu> listTwo = menuMapper.selectByExample(null);
        for (DgSysMenu tree_menu_two : listTwo) {
            Map<String, Object> map = new HashMap<String, Object>();
            Integer id = tree_menu_two.getId();
            for (DgSysRolePermission roleMenu : list1) {
                Integer menuId = roleMenu.getRoleid();
                if (id.equals(menuId)) {
                    tree_menu_two.setStatus("1");
                    break;
                }
            }
            map.put("id", tree_menu_two.getId());
            map.put("mid", id);
            map.put("name", tree_menu_two.getName());
            map.put("menuUrl", tree_menu_two.getUrl());
//            map.put("menuOrder", tree_menu_two.getMenuOrder());
//            map.put("menuIcon", tree_menu_two.getMenuIcon());
            map.put("checked", tree_menu_two.getStatus());
//            Integer menuLevel = tree_menu_two.get();
            if (tree_menu_two.getPid() > 1) {
                map.put("pid", tree_menu_two.getPid());
            } else {
                map.put("pid", 0);
            }
            map.put("mpid", tree_menu_two.getPid());
            list.add(map);
        }
        return list;
    }
}
