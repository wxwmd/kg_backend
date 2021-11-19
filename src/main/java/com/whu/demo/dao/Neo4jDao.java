package com.whu.demo.dao;

import org.neo4j.driver.*;


public class Neo4jDao {
    private Session session;

    public Neo4jDao() {
        Driver driver= GraphDatabase.driver("neo4j://39.107.233.150:7687",
                AuthTokens.basic("neo4j","123456"));
        session=driver.session();
    }

    public String  getAnswer1(){
        String result=session.readTransaction(new TransactionWork<String>() {
            @Override
            public String execute(Transaction transaction) {
                Result run = transaction.run("match (a{name:'即刻膀胱灌注化疗'})-[:禁忌症]->(b) where (b:临床所见 or b:疾病)  match (b)-->(c) return c.name");
                return run.next().get(0).toString();
            }
        });
        return result;
    }

}
