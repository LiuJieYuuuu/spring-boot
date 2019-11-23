package com.online.demo.service;

import com.online.demo.config.logInfoContent;
import com.online.demo.dao.LoginDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class LoginService {

    @Autowired
    LoginDao loginDao;

    @logInfoContent(content = "登录")
    public List<Map<String,Object>> getUserInfo(String username,String password){
        return loginDao.getUserInfo(username,password);
    }

    @logInfoContent(content = "更换头像")
    public boolean updateImageName(String newName,String email){
        return loginDao.updateImageName(newName,email);
    }

    @logInfoContent(content = "根据角色ID获取左侧菜单栏")
    public List<Map<String,Object>> getModulesSon(String role_id){
        return loginDao.getModulesSon(role_id);
    }
}
