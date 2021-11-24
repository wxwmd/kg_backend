package com.whu.study_help.dao;

import com.alibaba.fastjson.JSON;
import com.whu.study_help.bean.ChoiceQuestion;
import com.whu.study_help.bean.TripleInstance;
import com.whu.study_help.bean.TripleTemplate;
import com.whu.study_help.service.TestService;

public class Test {
    public static void main(String[] args) {
        TripleTemplate tripleTemplate=new TripleTemplate("疾病","临床表现","临床所见","name","name");
        TestService testService=new TestService();
        System.out.println(JSON.toJSONString(testService.getChoiceQuestions(tripleTemplate,3)));
    }


}
