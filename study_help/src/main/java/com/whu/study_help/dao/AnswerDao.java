package com.whu.study_help.dao;

import org.neo4j.driver.*;
import org.neo4j.driver.util.Pair;

import java.util.List;

public class AnswerDao {
    private Session session;

    public AnswerDao() {
        Driver driver= GraphDatabase.driver("neo4j://localhost:7687",
                AuthTokens.basic("neo4j","123456"));
        session=driver.session();
    }

    public String  getAnswer(String text){
        String[] texts=text.split("的");
        String head=texts[0];
        String relation=texts[1];
        String result=session.readTransaction(new TransactionWork<String>() {
            @Override
            public String execute(Transaction transaction) {
                Result result1 = transaction.run(String.format("match (n{name:'%s'})-[r:`%s`]->(n1) return n1.name", head,relation));
                if(result1.hasNext()){
                    List<Pair<String, Value>> fields = result1.single().fields();
                    Value value = fields.get(0).value();
                    System.out.println(value);
                    return value.toString();
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
