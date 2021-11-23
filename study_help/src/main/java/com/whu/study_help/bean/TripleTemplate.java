package com.whu.study_help.bean;

public class TripleTemplate {
    private String head;
    private String relation;
    private String tail;
    private String headProperty;

    public String getHeadProperty() {
        return headProperty;
    }

    public void setHeadProperty(String headProperty) {
        this.headProperty = headProperty;
    }

    public String getTailProperty() {
        return tailProperty;
    }

    public void setTailProperty(String tailProperty) {
        this.tailProperty = tailProperty;
    }

    private String tailProperty;

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getRelation() {
        return relation;
    }

    @Override
    public String toString() {
        return "TripleTemplate{" +
                "head='" + head + '\'' +
                ", relation='" + relation + '\'' +
                ", tail='" + tail + '\'' +
                ", headProperty='" + headProperty + '\'' +
                ", tailProperty='" + tailProperty + '\'' +
                '}';
    }

    public TripleTemplate(String head, String relation, String tail, String headProperty, String tailProperty) {
        this.head = head;
        this.relation = relation;
        this.tail = tail;
        this.headProperty = headProperty;
        this.tailProperty = tailProperty;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getTail() {
        return tail;
    }

    public void setTail(String tail) {
        this.tail = tail;
    }
}
