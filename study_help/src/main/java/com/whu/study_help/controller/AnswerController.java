package com.whu.study_help.controller;

import com.whu.study_help.service.AnswerService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class AnswerController {

    @RequestMapping("/answer")
    public String getAnswer(String text){
        AnswerService answerService=new AnswerService();
        return answerService.getAnswer(text);
    }
}
