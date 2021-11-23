package com.whu.study_help.bean;

public class TripleInstance {
    private TripleTemplate tripleTemplate;
    private String headInstance;
    private String tailInstance;

    public String getHeadInstance() {
        return headInstance;
    }

    public void setHeadInstance(String headInstance) {
        this.headInstance = headInstance;
    }

    public String getTailInstance() {
        return tailInstance;
    }

    public void setTailInstance(String tailInstance) {
        this.tailInstance = tailInstance;
    }

    public TripleTemplate getQuestionTemplate() {
        return tripleTemplate;
    }

    public void setQuestionTemplate(TripleTemplate tripleTemplate) {
        this.tripleTemplate = tripleTemplate;
    }

    public TripleInstance(TripleTemplate tripleTemplate) {
        this.tripleTemplate = tripleTemplate;
    }
}
