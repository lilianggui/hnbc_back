package com.llg.hnbc.service.impl;

import com.llg.hnbc.entity.Answer;
import com.llg.hnbc.entity.Question;
import com.llg.hnbc.mapper.dao.QuestionMapper;
import com.llg.hnbc.service.interfaces.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    @Override
    public void add(Question question) {
        questionMapper.add(question);
        List<Answer> answers = question.getAnswers();
        questionMapper.addAnswer(answers);
    }

    @Override
    public List<Question> listQuestion(Question question) {
        return questionMapper.listQuestion(question);
    }

    @Override
    @Transactional
    public void delete(Question question) {
        //删除问题本身
        questionMapper.delete(question);
        //删除问题的所有选项答案
        questionMapper.deleteAnswerByQuestionId(question);
    }

    @Override
    public Integer getQuestionCount() {
        return questionMapper.getQuestionCount();
    }

    @Override
    @Transactional
    public void updateQuestion(Question question) {
        //删除问题的所有选项答案
        questionMapper.deleteAnswerByQuestionId(question);
        //修改问题本身
        questionMapper.updateQuestion(question);
        //插入新的答案
        List<Answer> answers = question.getAnswers();
        questionMapper.addAnswer(answers);
    }
}
