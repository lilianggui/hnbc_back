package com.llg.hnbc.service.interfaces;

import com.llg.hnbc.entity.Question;

import java.util.List;

public interface QuestionService {
    void add(Question question);

    List<Question> listQuestion(Question question);

    void delete(Question question);

    void updateQuestion(Question question);

    Integer getQuestionCount();
}
