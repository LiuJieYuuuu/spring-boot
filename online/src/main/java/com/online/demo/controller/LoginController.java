package com.online.demo.controller;

import com.online.demo.dao.LoginDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    LoginDao loginDao;

    @RequestMapping(value="/toLogin")
    public String toLogin(HttpServletRequest request){
        request.setAttribute("root",request.getContextPath());
        return "index";
    }

    @PostMapping(value = "/main.do")
    public String toMain(HttpServletRequest request, HttpServletResponse response, String username, String password,String remeber){
        request.setAttribute("root",request.getContextPath());
        List<Map<String,Object>> list=loginDao.getUserInfo(username,password);
        if(!list.isEmpty()){
            if (remeber!=null){
                Cookie cookie = new Cookie("username",username);
                cookie.setMaxAge(60*60);
                cookie.setValue(username);
                response.addCookie(cookie);
            }
            request.getSession().setAttribute("user",list.get(0));
            return "redirect:/main";
        }else{
            request.setAttribute("message","用户名或密码错误！");
            return "index";
        }
    }

    @RequestMapping(value = "/main")
    public String mainHtml(HttpServletRequest request){
        request.setAttribute("userInfo",request.getSession().getAttribute("user"));
        return "service/main";
    }

    @RequestMapping(value = "/Timeout")
    public String Timeout(){
        return "timeout";
    }

    @RequestMapping(value = "logout")
    public String Logout(HttpServletRequest request){
        request.getSession().removeAttribute("user");
        return "redirect:/toLogin";
    }

}
