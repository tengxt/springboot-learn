package com.tengxt.community.mapper;

import com.tengxt.community.bean.Question;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
public interface QuestionMapper {

    @Insert("INSERT INTO question(title,description,gmt_create,gmt_modified,creator,tag) VALUES (#{title},#{description},#{gmtCreate},#{gmtModified},#{creator},#{tag})")
    Integer save(Question question);

    @Select("SELECT count(1) FROM question")
    Integer count();

    @Select("SELECT * FROM question LIMIT #{offset},#{size}")
    List<Question> list(@RequestParam("offset") Integer offset, @RequestParam("size") Integer size);

    @Select("SELECT count(1) FROM question WHERE creator = #{userId} ")
    Integer countByUserId(@RequestParam("userId") Integer userId);

    @Select("SELECT * FROM question WHERE creator = #{userId} LIMIT #{offset},#{size}")
    List<Question> listByUserId(@RequestParam("userId") Integer userId,@RequestParam("offset") Integer offset, @RequestParam("size") Integer size);

    @Select("SELECT * FROM question WHERE id = #{id}")
    Question findById(@Param("id") Integer id);

    @Update("UPDATE question SET title=#{title},description=#{description},gmt_modified=#{gmtModified},creator=#{creator},tag=#{tag} WHERE id=#{id}")
    Integer update(Question question);
}
