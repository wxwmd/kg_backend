package com.whu.study_help.dao;

import org.neo4j.driver.*;
import org.neo4j.driver.util.Pair;

import java.util.List;
import java.util.Map;

public class InstanceDao {
    private Session session;

    public InstanceDao() {
        Driver driver= GraphDatabase.driver("neo4j://localhost:7687",
                AuthTokens.basic("neo4j","123456"));
        session=driver.session();
    }

    public String  searchInstance(String name){
        String result=session.readTransaction(new TransactionWork<String>() {
            @Override
            public String execute(Transaction transaction) {
                Result result1 = transaction.run(String.format("match (n{name:'%s'}),(n)-[r:`实例`]->(n1) return n1.text", name));
                if(result1.hasNext()){
                    Map<String, Object> stringObjectMap = result1.next().asMap();
                    System.out.println(stringObjectMap);
                    return (String) stringObjectMap.get("n1.text");
                }else{
                    return null;
                }
            }
        });
        return result;
    }

    public void destory(){
        session.close();
    }
}
