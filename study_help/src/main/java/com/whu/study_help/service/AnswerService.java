package com.whu.study_help.service;

import com.whu.study_help.dao.AnswerDao;

public class AnswerService {
    public AnswerService() {
    }

    public String getAnswer(String text){
        AnswerDao answerDao=new AnswerDao();
        String answer = answerDao.getAnswer(text);
        answerDao.destory();
        return answer;
    }
}
