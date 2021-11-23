package com.whu.study_help.dao;

import com.whu.study_help.bean.TripleTemplate;

public class Test {
    public static void main(String[] args) {
        TripleInstanceDao tripleInstanceDao=new TripleInstanceDao();
        TripleTemplate tripleTemplate=new TripleTemplate("临床问题","推荐意见","推荐意见","name","name");
        System.out.println(tripleInstanceDao.getTripleInstance(tripleTemplate));
    }
}
