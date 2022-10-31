package com.QuestionBackend.service;

import com.QuestionBackend.model.*;

import java.util.List;

public interface DemoService {
    public List<QuestionBean> getInfo();
    List<SiteBean> getSiteInfo();

    ContentBean getContent(String userId, String siteId);

    String queryPreAns(int qid);

    int writeAnswer(AnswerVO answerVO);

    ResultBean statSelections(int qid);

    int statSingleSelectionNum(int qid, String optText);
}
