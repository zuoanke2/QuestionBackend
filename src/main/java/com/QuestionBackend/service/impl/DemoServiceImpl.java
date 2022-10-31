package com.QuestionBackend.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.QuestionBackend.mapper.AnswerMapper;
import com.QuestionBackend.mapper.QuestionMapper;
import com.QuestionBackend.mapper.SiteMapper;
import com.QuestionBackend.model.*;
import com.QuestionBackend.service.DemoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Service
public class DemoServiceImpl implements DemoService {
    @Resource
    private QuestionMapper questionMapper;
    @Resource
    private SiteMapper siteMapper;
    @Resource
    private AnswerMapper answerMapper;
    @Override
    public List<QuestionBean> getInfo() {
       List<QuestionBean> listBean = questionMapper.getListBean();
       return listBean;
//       return JSONObject.toJSONString(listBean);
    }

    public List<SiteBean> getSiteInfo() {
        List<SiteBean> siteBeanList = siteMapper.getSiteInfo();
        return siteBeanList;
    }

    public SiteBean getSingleSite(String siteId) {
        SiteBean siteBean = siteMapper.getSingleSite(siteId);
        return siteBean;
    }

    public QuestionBean getSingleQuestion(int qid) {
        return questionMapper.getSingleQuestion(qid);
    }

    public ContentBean getContent(String userId, String siteId) {
        ContentBean contentBean = new ContentBean();
        JSONArray qidlist = getSingleSite(siteId).getQlist();
        Collections.shuffle(qidlist);
        List<QuestionBean> tempList = new LinkedList<>();
        for (Object qid : qidlist) {
            tempList.add(questionMapper.getSingleQuestion((Integer)qid));
        }
        contentBean.setqList(tempList);
        contentBean.setUserid(userId);
        return contentBean;
    }

    public String queryPreAns(int qid) {
        return questionMapper.queryPreAns(qid);
    }

    public int writeAnswer(AnswerVO answerVO) {
        answerMapper.writeAnswer(answerVO);
        return 1;
    }

    public int statSingleSelectionNum(int qid, String optText) {
        return answerMapper.statSingleSelectionNum(qid, optText);
    }

    public ResultBean statSelections(int qid) {
        QuestionBean questionBean = questionMapper.getSingleQuestion(qid);
        JSONArray selections = questionBean.getSelections();
        ResultBean resultBean = new ResultBean();
        List<ItemStat> itemStatList = new LinkedList<>();
        for (Object selection : selections) {
            ItemStat itemStat = new ItemStat();
            itemStat.setName(selection.toString());
            itemStat.setCount(statSingleSelectionNum(qid, selection.toString()));
            itemStatList.add(itemStat);
        }
        resultBean.setStatList(itemStatList);
        return resultBean;
    }
}
