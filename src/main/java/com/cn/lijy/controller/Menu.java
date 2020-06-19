package com.cn.lijy.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lijy
 * @descriptin 菜单数据管理
 * @since
 */
public class Menu {


    /*public List<Map<String, Object>> menuData(Integer roleId) {
        //封装所有数据
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        //获取到 当前角色下的 菜单id
        List<PageData> list1;
        if (roleId == null || roleId == -1) {
            list1 = new ArrayList<>();
        } else {
            list1 = permissionDao.queryMenuBuyRoleId(roleId);
        }
        //查询二级 和一下的菜单封装
        List<Menu> listTwo = teacherDao.queryMenu(2);
        for (Menu tree_menu_two : listTwo) {
            Map<String, Object> map = new HashMap<String, Object>();
            Integer id = tree_menu_two.getId();
            for (PageData roleMenu : list1) {
                Integer menuId = roleMenu.getInt("menuId");
                if (id.equals(menuId)) {
                    tree_menu_two.setChecked(true);
                    break;
                }
            }
            map.put("id", Integer.valueOf(tree_menu_two.getMenuLevel() + "" + id));
            map.put("mid", id);
            map.put("name", tree_menu_two.getMenuName());
            map.put("menuUrl", tree_menu_two.getMenuUrl());
            map.put("menuOrder", tree_menu_two.getMenuOrder());
            map.put("menuIcon", tree_menu_two.getMenuIcon());
            map.put("checked", tree_menu_two.isChecked());
            Integer menuLevel = tree_menu_two.getMenuLevel();
            if (menuLevel > 1) {
                map.put("pid", Integer.valueOf((menuLevel - 1) + "" + tree_menu_two.getPid()));
            } else {
                map.put("pid", 0);
            }
            map.put("mpid", tree_menu_two.getPid());
            list.add(map);
        }
        return list;
    }*/
}
