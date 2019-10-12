package com.online.demo.service;

import com.online.demo.dao.LoginDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class LoginService {

    @Autowired
    LoginDao loginDao;

    public List<Map<String,Object>> getUserInfo(String username,String password){
        return loginDao.getUserInfo(username,password);
    }

    public boolean updateImageName(String newName,String email){
        return loginDao.updateImageName(newName,email);
    }

    public List<Map<String,Object>> getModulesSon(String role_id){
        return loginDao.getModulesSon(role_id);
    }
}
