package com.whu.study_help.dao;



import org.neo4j.driver.*;
import org.neo4j.driver.util.Pair;

import java.util.List;

public class SearchDao {
    private Session session;

    public SearchDao() {
        Driver driver= GraphDatabase.driver("neo4j://localhost:7687",
                AuthTokens.basic("neo4j","123456"));
        session=driver.session();
    }

    public String  searchEntity(String name){
        String result=session.readTransaction(new TransactionWork<String>() {
            @Override
            public String execute(Transaction transaction) {
                Result result1 = transaction.run(String.format("match (n{name:'%s'}) return properties(n)", name));
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
