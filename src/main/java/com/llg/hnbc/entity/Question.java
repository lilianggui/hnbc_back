package com.llg.hnbc.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Question {
    private Integer id;
    private String title;
    private String questExplain;
    private String createBy;
    private String updateBy;
    private Date createTime;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String answer;

    private String queryType;

    @JsonIgnore
    public String getQueryType() {
        return queryType;
    }

    public void setQueryType(String queryType) {
        this.queryType = queryType;
    }

    @JsonIgnore
    public List<Answer> getAnswers(){
        List<Answer> answers = new ArrayList<>();
        answers.add(new Answer(this.getId(), "A", this.getOptionA()));
        answers.add(new Answer(this.getId(), "B", this.getOptionB()));
        answers.add(new Answer(this.getId(), "C", this.getOptionC()));
        answers.add(new Answer(this.getId(), "D", this.getOptionD()));
        return answers;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getQuestExplain() {
        return questExplain;
    }

    public void setQuestExplain(String questExplain) {
        this.questExplain = questExplain;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

}
