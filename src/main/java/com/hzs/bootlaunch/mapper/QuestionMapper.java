package com.hzs.bootlaunch.mapper;

import com.hzs.bootlaunch.model.Question;
import com.hzs.bootlaunch.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
@CacheNamespace
@Mapper
@Repository
public interface QuestionMapper {
    @Insert("insert into question(title,description,gmt_create,gmt_modified,creator,tag) values (#{title},#{description},#{gmtCreate},#{gmtModified},#{creator},#{tag})")
    @Results({
            @Result(property = "gmtCreate",column = "gmt_create"),
            @Result(property = "gmtModified",column = "gmt_modified"),
            @Result(property = "commentCount",column = "comment_count"),
            @Result(property = "viewCount",column = "view_count"),
            @Result(property = "likeCount",column = "like_count"),
    })
    void create(Question question);

    @Select("select * from question")
    @Results({
            @Result(property = "creator",column = "creator" ,one = @One(select = "com.hzs.bootlaunch.mapper.QuestionMapper.getUser")),
    })
    List<Question> allQuestion();

    @Select("select avatar_url from User where id=#{id}")
    String getUser(@Param("id")Integer creator);
}
