package com.whu.study_help.service;

import com.whu.study_help.dao.SearchDao;


public class SearchSevice {
    private SearchDao searchDao;

    public SearchSevice() {
        this.searchDao = new SearchDao();
    }

    public String searchEntity(String name){
        return searchDao.searchEntity(name);
    }

    public void destory(){
        searchDao.destory();
    }
}
