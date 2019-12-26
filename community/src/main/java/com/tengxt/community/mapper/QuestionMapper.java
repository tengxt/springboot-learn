package com.tengxt.community.mapper;

import com.tengxt.community.bean.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
public interface QuestionMapper {

    @Insert("INSERT INTO question(title,description,gmt_create,gmt_modified,creator,tag) VALUES (#{title},#{description},#{gmtCreate},#{gmtModified},#{creator},#{tag})")
    int save(Question question);

    @Select("SELECT count(1) FROM question")
    Integer count();

    @Select("SELECT * FROM question LIMIT #{offset},#{size}")
    List<Question> list(@RequestParam("offset") Integer offset, @RequestParam("size") Integer size);
}
