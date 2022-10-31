package com.QuestionBackend.mapper;

import com.QuestionBackend.model.AnswerVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AnswerMapper {
    int writeAnswer(AnswerVO answerVO);
    int statSingleSelectionNum(int qId, String optText);

}
