package com.whu.study_help.dao;

import com.alibaba.fastjson.JSON;
import com.whu.study_help.bean.ChoiceQuestion;
import com.whu.study_help.bean.TripleInstance;
import com.whu.study_help.bean.TripleTemplate;

public class Test {
//    public static void main(String[] args) {
//        TripleInstanceDao tripleInstanceDao=new TripleInstanceDao();
//        TripleTemplate tripleTemplate=new TripleTemplate("疾病","临床表现","临床所见","name","name");
//        TripleInstance tripleInstance = tripleInstanceDao.getTripleInstance(tripleTemplate);
//        ChoiceQuestion choiceQuestion=new ChoiceQuestion(tripleInstance);
//        System.out.println(JSON.toJSONString(choiceQuestion));
//    }

    public static void main(String[] args) {
        TripleInstanceDao tripleInstanceDao=new TripleInstanceDao();
        tripleInstanceDao.getEntityInstance("临床所见","name",4).forEach(System.out::println);
    }

}
