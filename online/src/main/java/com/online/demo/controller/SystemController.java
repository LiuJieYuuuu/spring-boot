package com.online.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/system")
public class SystemController {

    @RequestMapping(value = "/moduleManager")
    public String getModulesInfo(HttpServletRequest request){
        return "service/system/modules";
    }
}
