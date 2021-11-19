package com.whu.demo.controller;

import com.whu.demo.service.Neo4jService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class neo4jController {
    private Neo4jService neo4jService=new Neo4jService();

    @RequestMapping("/jjz")
    public String getAnswer1(){
        return neo4jService.getAnswer1();
    }
}
