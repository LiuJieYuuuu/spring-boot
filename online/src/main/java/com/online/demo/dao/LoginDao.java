package com.online.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface LoginDao {
    @Select("select * from on_user where email=#{email} and password=#{password}")
    List<Map<String,Object>> getUserInfo(@Param("email") String email, @Param("password") String password);
}
