package com.QuestionBackend.mapper;

import com.QuestionBackend.model.SiteBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SiteMapper {
    List<SiteBean> getSiteInfo();
    SiteBean getSingleSite(String siteId);
}
