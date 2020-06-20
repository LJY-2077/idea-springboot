package com.cn.dg.controller;

import com.cn.dg.bean.system.DgSysMenu;
import com.cn.dg.service.SystemMenuService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author lijy
 * @descriptin 菜单数据管理
 * @since
 */
@RestController
public class MenuController {
    @Autowired
    SystemMenuService portalFolderService;

    @RequestMapping(value = "/currentFolderList")
    @ResponseBody
    public String currentFolderList(String currentpageId, ModelMap model) {
        //获取所有的节点列表
        List<DgSysMenu> folderList = portalFolderService.getFolderList();
        //封装成json格式,我引入的是import net.sf.json.JSONArray;
        JSONArray jsonArray = JSONArray.fromObject(folderList);
        //将json转成字符串
        String json = jsonArray.toString();
        return json;
    }
}
