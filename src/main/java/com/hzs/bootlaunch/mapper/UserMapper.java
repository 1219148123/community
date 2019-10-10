package com.hzs.bootlaunch.mapper;

import com.hzs.bootlaunch.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UserMapper {
    @Insert("insert into user(name,account_id,token,gmt_create,gmt_modified) values (#{name} ,#{accountId},#{token},#{gmtCreate},#{gmtModified})")
    void insert(User user);
}
