package com.online.demo.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.online.demo.entity.ParentModule;
import com.online.demo.service.SystemService;
import com.online.demo.util.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/system")
public class SystemController {

    @Autowired
    private SystemService systemService;

    @RequestMapping(value = "/moduleManager")
    public String getModulesInfo(HttpServletRequest request) throws UnsupportedEncodingException {
        request.setAttribute("root",request.getContextPath());
        List<Map<String,Object>> list=systemService.getAllModulesInfo();
        List<ParentModule> roleName=MapUtils.getModilesInfo(list,request);
        request.setAttribute("roles",java.net.URLEncoder.encode(JSON.toJSONString(roleName),"UTF-8"));
        return "service/system/modules";
    }

    @RequestMapping(value="/getParentModules")
    @ResponseBody
    public List<Map<String,Object>> getParentModules(){
        return systemService.getParentModulesInfo();
    }

    @RequestMapping(value = "/addmodule")
    public String addModuleHtml(HttpServletRequest request) throws UnsupportedEncodingException {
        request.setAttribute("root",request.getContextPath());
        List<Map<String,Object>> list=systemService.getParentModulesInfo();
        request.setAttribute("modules",java.net.URLEncoder.encode(JSON.toJSONString(list),"UTF-8"));
        return "service/system/addModule";
    }

    @ResponseBody
    @RequestMapping(value = "/addmodulesInfo")
    public String addModulesInfo(HttpServletRequest request){
        String isP=request.getParameter("switch");
        Map map=request.getParameterMap();
        System.out.println(map);
        if(isP!=null && !isP.equals("")){
            String p_name=request.getParameter("p_name");
            if(systemService.addParentModules(p_name))
                return "success";
            else
                return "error";
        }else{
            String s_name=request.getParameter("s_name");
            String url=request.getParameter("url");
            Integer parent_id=Integer.parseInt(request.getParameter("pmodules"));
            if(systemService.addSonModules(s_name,url,parent_id))
                return "success";
            else
                return "error";
        }
    }

    @RequestMapping(value = "/deleteSonModule")
    @ResponseBody
    public String deleteSonModules(String id){
        if(id.contains("children"))
            if(systemService.deleteSonModules(id.split("_")[0]))
                return "success";
            else
                return "error";
        else if(id.contains("parent"))
            if(systemService.deleteParentModules(id.split("_")[0]))
                return "success";
            else
                return "error";
        else
            return "error";
    }

    @RequestMapping(value = "/updateModule")
    @ResponseBody
    public String updateModules(String id,String p_name,String s_name,String pmodules,String url){
        if(id.contains("parent")){
            if(systemService.updateParentModule(id.split("_")[0],p_name))
                return "success";
            else
                return "error";
        }else if(id.contains("children")){
            if(systemService.updateSonModule(id.split("_")[0],s_name,pmodules,url))
                return "success";
            else
                return "error";
        }else{
            return "error";
        }
    }

    @RequestMapping(value = "/getRolesById")
    @ResponseBody
    public List<Map<String,Object>> getRoleTemplateById(String id){
        return systemService.getRoleTemplates(id.split("_")[0]);
    }

    @RequestMapping(value = "/addRoleById")
    @ResponseBody
    public String addRolesByTemplateId(String id,String list){
        return systemService.updateRolesTemplate(id.split("_")[0],list);
    }

    @RequestMapping(value = "/roles")
    @ResponseBody
    public String rolesInfo(HttpServletRequest request){
        request.setAttribute("root",request.getContextPath());
        return "service/system/roles";
    }

    @ResponseBody
    @RequestMapping(value = "/getRolesInfo")
    public List<Map<String,Object>> getRolesInfo(HttpServletRequest request){
        String limit=request.getParameter("limit");
        String page=request.getParameter("page");

        return systemService.getRolesInfo();
    }
}
