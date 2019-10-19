package com.hzs.bootlaunch.mapper;

import com.hzs.bootlaunch.model.Question;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
@CacheNamespace
@Mapper
@Repository
public interface QuestionMapper {
    @Insert("insert into question(title,description,gmt_create,gmt_modified,creator,tag) values (#{title},#{description},#{gmtCreate},#{gmtModified},#{creator},#{tag})")
    void create(Question question);
    @Results({
            @Result(property = "gmtCreate",column = "gmt_create"),
            @Result(property = "gmtModified",column = "gmt_modified"),
            @Result(property = "commentCount",column = "comment_count"),
            @Result(property = "viewCount",column = "view_count"),
            @Result(property = "likeCount",column = "like_count"),
    })
    @Select("select * from question")
    List<Question> allQuestion();
}
