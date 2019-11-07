package com.online.demo.service;

import com.online.demo.dao.SystemDao;
import com.online.demo.util.DataSourceTemplate;
import com.online.demo.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class SystemService {
    @Autowired
    private SystemDao systemDao;

    @Autowired @Qualifier("mysqlOnDataSourceTemplate")
    private DataSourceTemplate template;

    public List<Map<String,Object>> getAllModulesInfo(){
        return systemDao.getAllModulesInfo();
    }

    public List<Map<String,Object>> getParentModulesInfo(){
        return systemDao.getParentModules();
    }

    public boolean addParentModules(String name){
        return systemDao.addParentModules(name);
    }

    public boolean addSonModules(String name,String url,Integer parent_id){
        return systemDao.addSonModules(name,url,parent_id);
    }

    public boolean deleteSonModules(String id){
        return systemDao.deleteSonModules(id);
    }


    public boolean deleteParentModules(String id){
        return systemDao.deleteParentModules(id);
    }

    public boolean updateParentModule(String id,String name){
        return systemDao.updateParentModule(id,name);
    }

    public boolean updateSonModule(String id,String name,String parent_id,String url){
        return systemDao.updateSonModule(id,name,parent_id,url);
    }

    public List<Map<String,Object>> getRoleTemplates(String id){
        return systemDao.getRoleTemplates(id);
    }

    public String updateRolesTemplate(String id,String list){
        String sql="insert into on_role_template(id,role_id,template_id) values(?,?,?)";
        List<Object[]> l=new ArrayList<>();
        for(String i : list.split(",")){
            l.add(new Object[]{UUIDUtils.getId(),i,id});
        }
        try{
            systemDao.delRolsTemplate(id);
            template.batchUpdate(sql,l);
            return "success";
        }catch(Exception e){
            e.printStackTrace();
            return "error";
        }
    }

    public List<Map<String,Object>> getRolesInfo(){
        return systemDao.getRolesInfo();
    }
}
