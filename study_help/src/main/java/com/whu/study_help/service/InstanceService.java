package com.whu.study_help.service;

import com.whu.study_help.dao.InstanceDao;

public class InstanceService {

    public InstanceService() {
    }

    public String getInstance(String name){
        InstanceDao instanceDao=new InstanceDao();
        String instance = instanceDao.searchInstance(name);
        instanceDao.destory();
        return instance;
    }
}
