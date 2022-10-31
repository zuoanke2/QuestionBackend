package com.QuestionBackend.model;

import com.alibaba.fastjson.JSONArray;

public class SiteBean {
    private String siteid;
    private String qlist;

    public String getSiteid() {
        return siteid;
    }

    public void setSiteid(String siteid) {
        this.siteid = siteid;
    }

    public JSONArray getQlist() {
        JSONArray questionList = JSONArray.parseArray(qlist);
        return questionList;
    }

    public void setQlist(String qlist) {
        this.qlist = qlist;
    }
}
