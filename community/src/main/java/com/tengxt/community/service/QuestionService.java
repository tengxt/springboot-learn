package com.tengxt.community.service;

import com.tengxt.community.bean.Question;
import com.tengxt.community.mapper.QuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    public int saveQuestion(Question question){
        question.setGmtCreate(System.currentTimeMillis());
        question.setGmtModified(question.getGmtCreate());
        return questionMapper.save(question);
    }
}
