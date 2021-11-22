package com.whu.study_help.controller;

import com.whu.study_help.service.InteractionService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class InteractionController {

    @RequestMapping("/interaction")
    public String getInteractions(String word){
        InteractionService interactionService=new InteractionService();
        String interactions = interactionService.getInteractions(word);
        interactionService.destory();
        return interactions;
    }

}
