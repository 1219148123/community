package com.hzs.bootlaunch.mapper;

import com.hzs.bootlaunch.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@CacheNamespace
@Mapper
@Repository
public interface UserMapper {
    @Insert("insert into user(name,account_id,token,gmt_create,gmt_modified,bio,avatar_url) values (#{name} ,#{accountId},#{token},#{gmtCreate},#{gmtModified},#{bio},#{avatarUrl})")
    void insert(User user);
    @Select("select * from user where token = #{token}")
    User findByToken(@Param("token") String token);
}
