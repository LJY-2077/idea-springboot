package com.cn.dg.controller;

import com.cn.dg.bean.system.DgSysUser;
import com.cn.dg.mapper.system.DgSysUserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author lijy
 * @descriptin
 * @since
 */
@Controller
@Slf4j
public class UserController {
    @Autowired
    DgSysUserMapper userMapper;

    @RequestMapping("/user/add")
    @RequiresPermissions("user:add")
    public String userAdd() {
        return "/pageuser/user_add";
    }

    @RequestMapping("/user/list")
    @RequiresPermissions("user:view")
    public String userlist(Model model) {

        List<DgSysUser> users = userMapper.selectByExample(null);
        model.addAttribute("users",users);
        return "/pageuser/user_list";
    }

    @RequestMapping("/user/del")
    @RequiresPermissions("user:del")
    public String userDel() {
        return "/pageuser/user_del";
    }
}

