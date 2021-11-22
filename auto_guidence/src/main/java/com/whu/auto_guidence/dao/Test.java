package com.whu.auto_guidence.dao;

import org.springframework.beans.factory.annotation.Autowired;

public class Test {

    public static void main(String[] args) {
        Neo4jDao neo4jDao=new Neo4jDao();
        String a=neo4jDao.getAnswer1();
        System.out.println(a);
    }
}
