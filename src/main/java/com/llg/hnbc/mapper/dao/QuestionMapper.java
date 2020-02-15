package com.llg.hnbc.mapper.dao;


import com.llg.hnbc.entity.Answer;
import com.llg.hnbc.entity.Question;

import java.util.List;

public interface QuestionMapper {
    void add(Question question);

    void addAnswer(List<Answer> answers);

    List<Question> listQuestion(Question question);

    void delete(Question question);

    void deleteAnswerByQuestionId(Question question);

    void updateQuestion(Question question);

    Integer getQuestionCount();
}
