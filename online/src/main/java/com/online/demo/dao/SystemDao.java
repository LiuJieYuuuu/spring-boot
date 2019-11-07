package com.online.demo.dao;

import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface SystemDao {

    @Select("select p.t_p_id,p.t_p_name,s.t_s_id,s.t_s_name,s.t_s_url,t_parent_id from on_template_p p " +
            "left join (select * from on_template_s where is_del=0) s on p.t_p_id=s.t_parent_id" +
            " where p.is_del=0")
    public List<Map<String,Object>> getAllModulesInfo();


    @Select("select t_p_id,t_p_name from on_template_p where is_del=0 ")
    public List<Map<String,Object>> getParentModules();

    @Insert("insert into on_template_p(t_p_name,is_del) values(#{name},0)")
    public boolean addParentModules(@Param("name") String name);

    @Insert("insert into on_template_s(t_s_name,t_s_url,t_parent_id,is_del) values(#{name},#{url},#{p_id},0)")
    public boolean addSonModules(@Param("name") String name,@Param("url") String url,@Param("p_id") Integer parent_id);

    @Update("update on_template_s set is_del=1 where t_s_id=#{s_id}")
    public boolean deleteSonModules(@Param("s_id") String id);

    @Update("update on_template_p set is_del=1 where t_p_id=#{p_id}")
    public boolean deleteParentModules(@Param("p_id") String id);
    Stats
    @Update("update on_template_p set t_p_name=#{p_name} where t_p_id=#{id}")
    public boolean updateParentModule(@Param("id") String id,@Param("p_name") String name);

    @Update("update on_template_s set t_s_name=#{s_name},t_parent_id=#{parent_id},t_s_url=#{url} where t_s_id=#{id}")
    public boolean updateSonModule(@Param("id") String id,@Param("s_name") String name,@Param("parent_id") String parent_id,@Param("url") String url);

    @Select("select r.role_id,r.role_name,p.id from on_role r left join (select * from on_role_template where template_id=#{id}) p on r.role_id=p.role_id")
    public List<Map<String,Object>> getRoleTemplates(@Param("id") String id);

    @Delete("delete from on_role_template where template_id=#{id}")
    public boolean delRolsTemplate(@Param("id") String id);

    @Select("select r.role_id,r.role_name,r.create_time,case when p.num is null then 0 else p.num end as num " +
            "from on_role r left join (select role_id,count(*) as num from on_user group by role_id) p " +
            " on p.role_id=r.role_id")
    public List<Map<String,Object>> getRolesInfo();
}
