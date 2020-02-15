package com.llg.hnbc.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.llg.hnbc.entity.Question;
import com.llg.hnbc.entity.vo.PageQO;
import com.llg.hnbc.result.Result;
import com.llg.hnbc.service.interfaces.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QuestionController {

    @Autowired
    private QuestionService questionService;


    @RequestMapping("test")
    public Result test(){
        return Result.buildBaseSuccess();
    }

    @PostMapping("addQuestion")
    public Result add(Question question){
        questionService.add(question);
        return Result.buildBaseSuccess();
    }

    @GetMapping("listQuestion")
    public Result listQuestion(Question question, PageQO pageQO){
        if("random".equals(question.getQueryType())){
            Integer count = questionService.getQuestionCount();
            int start = (int)(Math.random() * count);
            pageQO.setPageSize(1);
            pageQO.setPageNum(start);
        }
        Page<Question> page = PageHelper.startPage(pageQO.getPageNum(), pageQO.getPageSize());
        List<Question> questions = questionService.listQuestion(question);
        return Result.buildPageSuccess(page, questions);
    }

    @PostMapping("updateQuestion")
    public Result updateQuestion(Question question){
        questionService.updateQuestion(question);
        return Result.buildBaseSuccess();
    }

    @PostMapping("deleteQuestion")
    public Result deleteQuestion(Question question){
        questionService.delete(question);
        return Result.buildBaseSuccess();
    }


}
