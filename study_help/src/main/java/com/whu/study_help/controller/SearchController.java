package com.whu.study_help.controller;

import com.whu.study_help.service.SearchSevice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class SearchController {



    @RequestMapping("/getEntity")
    public String SearchEntity(String name){
        SearchSevice searchSevice=new SearchSevice();
        String result = searchSevice.searchEntity(name);
        searchSevice.destory();
        return result;
    }
}
