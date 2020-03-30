package com.example.demo.dao;

import com.example.demo.model.UserModel;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


import java.util.List;
public interface UserDao {
    @Select("select count(*) from User1 where id like '%${id}%'")
    public Integer getCount(@Param("id") Integer id);
    @Select("select * from (select t.*,rownum as num from USER1 t where rownum<=(${page}*${limit}))team where team.num>=((${page}-1)*${limit}) order by id")
    public List<UserModel> loadUser(@Param("page") Integer page,@Param("limit") Integer limit,@Param("id") Integer id);


}
