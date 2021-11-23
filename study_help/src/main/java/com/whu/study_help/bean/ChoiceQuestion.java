package com.whu.study_help.bean;

import java.util.List;

public class ChoiceQuestion extends Question {
    private String text;
    private List<String> choices;
    private String answer;

    public ChoiceQuestion(TripleInstance tripleInstance ,List<String>choices) {
        super(tripleInstance);
        text=String.format("%s的%s是_____",this.tripleInstance.getHeadInstance(),this.tripleInstance.getQuestionTemplate().getRelation());
        this.choices=choices;
        answer=this.tripleInstance.getTailInstance();
    }

    @Override
    public String getText() {
        return text;
    }

    public List<String> getChoice(){
        return choices;
    }

    @Override
    public String getAnswer() {
        return answer;
    }

}
