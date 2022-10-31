package com.QuestionBackend.controller;

import com.QuestionBackend.model.*;
import com.QuestionBackend.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuestionController {
    @Autowired
    private DemoService demoService;
    @GetMapping("/questions/get")
    public List<QuestionBean> getAllQuestions() {
        return demoService.getInfo();
    }

    @GetMapping("/siteInfo/get")
    public List<SiteBean> getAllSiteInfo() {
        return demoService.getSiteInfo();
    }

    @PostMapping("/contents/get")
    public ContentBean getContent(@RequestParam("userId") String userId, @RequestParam("siteId") String siteId) {
        return demoService.getContent(userId, siteId);
    }

    @PostMapping("/Answer")
    public ResultBean answerQuestion(@RequestBody AnswerVO answerVO) {
        String preAns = demoService.queryPreAns(answerVO.getqId());
        if (!preAns.equals("null")) {
            if (preAns.equals(answerVO.getOptionText())) {
                answerVO.setResult("Correct");
            } else {
                answerVO.setResult("Incorrect");
            }
        } else {
            answerVO.setResult("No result");
        }
        ResultBean resultBean = new ResultBean();
        if (demoService.writeAnswer(answerVO) == 1 && answerVO.getType().equals("quiz")) {
            resultBean = demoService.statSelections(answerVO.getqId());
        }
        resultBean.setResult(answerVO.getResult());
        return resultBean;
    }
}
