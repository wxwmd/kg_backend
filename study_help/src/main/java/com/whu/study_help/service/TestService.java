package com.whu.study_help.service;

import com.whu.study_help.bean.ChoiceQuestion;
import com.whu.study_help.bean.TripleInstance;
import com.whu.study_help.bean.TripleTemplate;
import com.whu.study_help.dao.TripleInstanceDao;

import java.util.LinkedList;
import java.util.List;

public class TestService {

    public List<ChoiceQuestion> getChoiceQuestions(TripleTemplate tripleTemplate,int num){
        TripleInstanceDao tripleInstanceDao=new TripleInstanceDao();
        List<ChoiceQuestion> choiceQuestions=new LinkedList<>();

        List<TripleInstance> tripleInstances = tripleInstanceDao.getTripleInstances(tripleTemplate, num);
        for (int i=0;i<num;i++){
            TripleInstance tripleInstance = tripleInstances.get(i);
            List<String> entityInstance = tripleInstanceDao.getEntityInstance(tripleTemplate.getTail(), tripleTemplate.getTailProperty(), 4);
            entityInstance.remove(tripleInstance.getTailInstance());
            List<String> choices = entityInstance.subList(0, 3);
            choices.add(tripleInstance.getTailInstance());
            ChoiceQuestion choiceQuestion=new ChoiceQuestion(tripleInstance,choices);
            choiceQuestions.add(choiceQuestion);
        }
        return choiceQuestions;
    }
}
