package com.jr.server.dao;

import com.jr.entity.Tb_User;
import org.apache.ibatis.annotations.Select;

public interface Tb_UserDao {
    @Select("select * from tb_user where flag=1 and phone=#{phone}")
    Tb_User selectByPhone(String phone);
}
