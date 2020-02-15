package com.llg.hnbc.entity;


public class Answer {
    private Integer id;
    private Integer questionId;
    private String optionNo;
    private String optionContent;

    public Answer() {
    }

    public Answer(Integer questionId, String optionNo, String optionContent) {
        this.questionId = questionId;
        this.optionNo = optionNo;
        this.optionContent = optionContent;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getOptionNo() {
        return optionNo;
    }

    public void setOptionNo(String optionNo) {
        this.optionNo = optionNo;
    }

    public String getOptionContent() {
        return optionContent;
    }

    public void setOptionContent(String optionContent) {
        this.optionContent = optionContent;
    }
}
