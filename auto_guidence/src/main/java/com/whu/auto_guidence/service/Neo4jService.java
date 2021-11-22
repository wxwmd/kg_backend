package com.whu.auto_guidence.service;


import com.whu.auto_guidence.dao.Neo4jDao;
import org.springframework.beans.factory.annotation.Autowired;

public class Neo4jService {
    private Neo4jDao neo4jDao;

    public Neo4jService() {
        neo4jDao = new Neo4jDao();
    }


    public String getAnswer1(){
        return neo4jDao.getAnswer1();
    }
}
