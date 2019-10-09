package com.online.demo.controller;

import com.online.demo.dao.LoginDao;
import com.online.demo.util.MapUtils;
import com.online.demo.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.URISyntaxException;
import java.util.Map;

@Controller
public class UserInfoController {

    @GetMapping(value = "/toUserInfo")
    public String redirectToUserInfo(HttpServletRequest request){
        request.setAttribute("root",request.getContextPath());
        return "service/userInfo";
    }

    @Value("${spring.servlet.multipart.location}")
    private String path;

    @Autowired
    private LoginDao loginDao;

    @ResponseBody
    @RequestMapping(value = "/fileUpload")
    public String FileUpload(@RequestParam("file") MultipartFile multipartFile,HttpServletRequest request) throws IOException, URISyntaxException {
        String name=multipartFile.getOriginalFilename();
        String lastType=name.substring(name.lastIndexOf(".")+1,name.length());
        String newName=UUIDUtils.getId()+"."+lastType;
        String email= MapUtils.getMapNullString((Map) request.getSession().getAttribute("user"),"email");
        File file=new File(this.getClass().getResource("/").toURI().getPath()+File.separator+path+newName);
        if (!file.exists())
            file.createNewFile();
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file));
        out.write(multipartFile.getBytes());
        out.flush();
        out.close();
        if (loginDao.updateImageName(newName,email))
            return "success";
        else
            return "fail";
    }

}
