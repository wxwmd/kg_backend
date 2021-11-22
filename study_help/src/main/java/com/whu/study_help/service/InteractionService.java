package com.whu.study_help.service;

import com.alibaba.fastjson.JSON;
import com.whu.study_help.dao.InteractionDao;

public class InteractionService {
    private InteractionDao interactionDao;

    public InteractionService(){
        interactionDao=new InteractionDao();
    }

    public String getInteractions(String word){
        return JSON.toJSONString(interactionDao.getInteractions(word));
    }

    public void destory(){
        interactionDao.destory();
    }
}
