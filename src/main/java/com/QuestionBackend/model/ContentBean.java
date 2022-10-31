package com.QuestionBackend.model;

import java.util.List;

public class ContentBean {
    private String userid;

    private List<QuestionBean> qList;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public List<QuestionBean> getqList() {
        return qList;
    }

    public void setqList(List<QuestionBean> qList) {
        this.qList = qList;
    }
}
