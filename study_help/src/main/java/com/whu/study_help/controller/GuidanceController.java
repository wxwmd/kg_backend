package com.whu.study_help.controller;

import com.whu.study_help.service.GuidanceSevice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class GuidanceController {


    @RequestMapping("getGuidance")
    public String getGuidance(String word){
        GuidanceSevice guidanceSevice=new GuidanceSevice();
        String guidances = guidanceSevice.getGuidances(word);
        guidanceSevice.destory();
        return guidances;
    }
}
