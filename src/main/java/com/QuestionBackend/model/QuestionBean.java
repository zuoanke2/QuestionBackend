package com.QuestionBackend.model;

import com.alibaba.fastjson.JSONArray;

public class QuestionBean {
    private int qid;
    private String question;
    private String preans;
    private String selections;
    private String type;

    public int getQid() {
        return qid;
    }

    public void setQid(int qid) {
        this.qid = qid;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getPreans() {
        return preans;
    }

    public void setPreans(String preans) {
        this.preans = preans;
    }

    public JSONArray getSelections() {
        JSONArray selectionsJson = JSONArray.parseArray(selections);
        return selectionsJson;
    }

    public void setSelections(String selections) {
        this.selections = selections;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
