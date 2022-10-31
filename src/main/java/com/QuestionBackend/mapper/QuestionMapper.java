package com.QuestionBackend.mapper;
import com.QuestionBackend.model.QuestionBean;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface QuestionMapper {
    List<QuestionBean> getListBean();
    QuestionBean getSingleQuestion(int qid);

    String queryPreAns(int qid);
}
