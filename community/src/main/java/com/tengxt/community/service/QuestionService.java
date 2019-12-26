package com.tengxt.community.service;

import com.tengxt.community.bean.Question;
import com.tengxt.community.bean.User;
import com.tengxt.community.dto.PaginationDTO;
import com.tengxt.community.dto.QuestionDTO;
import com.tengxt.community.mapper.QuestionMapper;
import com.tengxt.community.mapper.UserMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private UserMapper userMapper;

    public int saveQuestion(Question question){
        question.setGmtCreate(System.currentTimeMillis());
        // 获取创建时间
        question.setGmtModified(question.getGmtCreate());
        return questionMapper.save(question);
    }

    public PaginationDTO questionDTOList(Integer page, Integer size){
        PaginationDTO paginationDTO = new PaginationDTO();

        // 总页数
        Integer totalPage;
        // 总条数
        Integer totalCount = questionMapper.count();

        if (totalCount % size == 0) {
            totalPage = totalCount / size;
        } else {
            totalPage = totalCount / size + 1;
        }

        if (page < 1) {
            page = 1;
        }
        if (page > totalPage) {
            page = totalPage;
        }

        paginationDTO.setPagination(totalPage, page);

        //size*(page-1)
        Integer offset = size * (page - 1);

        List<QuestionDTO> dtoList = null;
        // 获取所有提问
        List<Question> questionList = questionMapper.list(offset, size);
        if(null != questionList && questionList.size() > 0){
            dtoList = new ArrayList<>();
            for (Question question : questionList) {
                // 获取用户信息
                User user = userMapper.findById(question.getCreator());
                if(null != user){
                    QuestionDTO questionDTO = new QuestionDTO();
                    //  把question类中的属性映射到QuestionDTO中 (反射)
                    BeanUtils.copyProperties(question, questionDTO);
                    questionDTO.setUser(user);
                    dtoList.add(questionDTO);
                }
            }
        }
        paginationDTO.setData(dtoList);
        return paginationDTO;
    }
}
