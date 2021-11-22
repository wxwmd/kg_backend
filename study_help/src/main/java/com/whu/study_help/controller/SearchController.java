package com.whu.study_help.controller;

import com.whu.study_help.service.SearchSevice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class SearchController {

    private SearchSevice searchSevice=new SearchSevice();

    @RequestMapping("/getEntity")
    public String SearchEntity(String name){

        return searchSevice.searchEntity(name);
    }
}
