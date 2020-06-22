package com.cn.dg.controller;

import com.cn.dg.bean.shiro.CacheUser;
import com.cn.dg.bean.shiro.Response;
import com.cn.dg.common.util.CaptchaUtil;
import com.cn.dg.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.util.Map;

/**
 * @author lijy
 * @descriptin
 * @since
 */
@Controller
@Slf4j
public class LoginController {
    @Resource
    private Response response;
    @Autowired
    IUserService userService;


    @RequestMapping("login")
    public String gologin() {
        return "login";
    }
    @RequestMapping("page_fore")
    public String pageFore() {
        return "page_fore";
    }


    @PostMapping(value = "/login_page")
    public Response loginShiro(@RequestParam("username") String username, @RequestParam("password") String password, Map<String, Object> map,
                               HttpSession session) {
        log.warn("进入登录.....");
        //验证用户名和密码，输入正确，跳转到dashboard

        if (StringUtils.isBlank(username)) {
            return response.failure("用户名为空！");
        }

        if (StringUtils.isBlank(password)) {
            return response.failure("密码为空！");
        }

        CacheUser loginUser = userService.login(username, password);
        if (loginUser == null) {
            return response.failure("账户或密码错误！");
        }
        // 登录成功返回用户信息
        return response.success("登录成功！", loginUser);

    }

    @RequestMapping(value = "/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "login";
    }

    @RequestMapping(value = "/menu")
    public String menu(HttpSession session) {
        return "/menu/menutree";
    }

    @RequestMapping(value = "/page_main")
    public String mainPage(HttpSession session) {
        return "/page_main";
    }

    /**
     * 获取验证码
     *
     * @param request
     * @param response
     */
    @RequestMapping("/Captcha.jpg")
    public void getCaptcha(HttpServletRequest request, HttpServletResponse response) {
        // 设置相应类型,告诉浏览器输出的内容为图片
        response.setContentType("image/jpeg");
        // 不缓存此内容
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expire", 0);
        try {
            HttpSession session = request.getSession();
            CaptchaUtil tool = new CaptchaUtil();
            StringBuffer code = new StringBuffer();
            BufferedImage image = tool.genRandomCodeImage(code);
            session.removeAttribute("valiCode");
            session.setAttribute("valiCode", code.toString());
            // 将内存中的图片通过流动形式输出到客户端
            ImageIO.write(image, "JPEG", response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 未登录，shiro应重定向到登录界面，此处返回未登录状态信息由前端控制跳转页面
     * <br/>
     * create by: leigq
     * <br/>
     * create time: 2019/7/3 14:53
     *
     * @return
     */
    @RequestMapping("/un_auth")
    public Response unAuth() {
        return response.failure(HttpStatus.UNAUTHORIZED, "用户未登录！", null);
    }

    /**
     * 未授权，无权限，此处返回未授权状态信息由前端控制跳转页面
     * <br/>
     * create by: leigq
     * <br/>
     * create time: 2019/7/3 14:53
     *
     * @return
     */
    @RequestMapping("/unauthorized")
    public Response unauthorized() {
        return response.failure(HttpStatus.FORBIDDEN, "用户无权限！", null);
    }
}
