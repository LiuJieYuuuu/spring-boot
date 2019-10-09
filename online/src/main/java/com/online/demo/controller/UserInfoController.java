package com.online.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserInfoController {

    @GetMapping(value = "/toUserInfo")
    public String redirectToUserInfo(){
        return "service/userInfo";
    }

}
