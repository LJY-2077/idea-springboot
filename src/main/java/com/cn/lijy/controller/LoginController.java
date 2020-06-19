package com.cn.lijy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author lijy
 * @descriptin
 * @since
 */
@Controller
public class LoginController {

    @RequestMapping("login")
    public String gologin() {
        return "login";
    }

    @PostMapping(value = "/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Map<String, Object> map,
                        HttpSession session) {

        //验证用户名和密码，输入正确，跳转到dashboard
        if (!StringUtils.isEmpty(username) && "123".equals(password)) {

            session.setAttribute("userName", username);
            System.out.println("----" + username);
            map.put("username", username);
            return "redirect:/menu";

        } else  //输入错误，清空session，提示用户名密码错误
        {
            session.invalidate();
            map.put("msg", "用户名密码错误");
            return "login";
        }
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("username");
        return "login";
    }

    @RequestMapping(value = "/menu")
    public String menu(HttpSession session) {
        return "/menu/menutree";
    }


    @RequestMapping("dashboard")
    public String goMain(HttpSession session, Model model) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        model.addAttribute("name", session.getAttribute("userName"));
        model.addAttribute("strList", list);
        model.addAttribute("show", false);
        return "success";
    }

}
