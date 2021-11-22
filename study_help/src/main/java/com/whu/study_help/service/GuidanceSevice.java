package com.whu.study_help.service;

import com.alibaba.fastjson.JSON;
import com.whu.study_help.dao.GuidanceDao;

import java.util.List;
import java.util.Map;

public class GuidanceSevice {
    private GuidanceDao guidanceDao;

    public GuidanceSevice(){
        guidanceDao=new GuidanceDao();
    }

    public String getGuidances(String word){
        List<Map<String, Object>> guidances = guidanceDao.getGuidances(word);
        return JSON.toJSONString(guidances);
    }

    public void destory(){
        guidanceDao.destory();
    }
}
