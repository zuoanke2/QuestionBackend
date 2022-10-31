package com.QuestionBackend.model;

import java.util.List;

public class ResultBean {
    String result;
    List<ItemStat> statList;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<ItemStat> getStatList() {
        return statList;
    }

    public void setStatList(List<ItemStat> statList) {
        this.statList = statList;
    }
}
