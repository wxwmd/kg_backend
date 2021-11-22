package com.whu.study_help.controller;

import com.whu.study_help.service.InstanceService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class InstanceController {
    @RequestMapping("/instance")
    public String getInstance(String name){
        InstanceService instanceService=new InstanceService();
        return instanceService.getInstance(name);
    }
}
