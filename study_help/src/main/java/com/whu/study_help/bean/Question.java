package com.whu.study_help.bean;

public abstract class Question {
    TripleInstance tripleInstance;

    public Question(TripleInstance tripleInstance) {
        this.tripleInstance = tripleInstance;
    }

    //获得题干
    abstract String getText();

    //获得答案
    abstract String getAnswer();
}
