package com.whu.study_help.dao;


import com.whu.study_help.bean.TripleInstance;
import com.whu.study_help.bean.TripleTemplate;
import org.neo4j.driver.*;
import org.neo4j.driver.util.Pair;

import java.util.LinkedList;
import java.util.List;

/*
* 医疗能力测试模块
* */
public class TripleInstanceDao {

    private Session session;

    public TripleInstanceDao() {
        Driver driver= GraphDatabase.driver("neo4j://localhost:7687",
                AuthTokens.basic("neo4j","123456"));
        session=driver.session();
    }

    public TripleInstance getTripleInstance(TripleTemplate tripleTemplate){
        String cql=String.format("MATCH (u:`%s`)-[r:`%s`]->(v:`%s`)\n" +
                "WITH u, v,rand() AS number\n" +
                "RETURN u.%s,v.%s\n" +
                "ORDER BY number\n" +
                "LIMIT 1",tripleTemplate.getHead(),tripleTemplate.getRelation(),tripleTemplate.getTail(),tripleTemplate.getHeadProperty(),tripleTemplate.getTailProperty());
        TripleInstance tripleInstance = session.readTransaction(new TransactionWork<TripleInstance>() {
            @Override
            public TripleInstance execute(Transaction transaction) {
                Result result1 = transaction.run(cql);
                if(result1.hasNext()){
                    List<Pair<String, Value>> fields1 = result1.next().fields();
                    System.out.println(fields1.toString());
                    String head = fields1.get(0).value().toString();
                    String tail=fields1.get(1).value().toString();
                    TripleInstance tripleInstance1=new TripleInstance(tripleTemplate);
                    tripleInstance1.setHeadInstance(head);
                    tripleInstance1.setTailInstance(tail);
                    return tripleInstance1;
                }else{
                    return null;
                }
            }
        });
        return tripleInstance;
    }

    public List<String> getEntityInstance(String entity,String property,int num){
        String cql=String.format("MATCH (n:`%s`) WITH n,rand() AS number RETURN n.%s order by number LIMIT %d",entity,property,num);
        System.out.println(cql);
        List<String> result = session.readTransaction(new TransactionWork<List<String>>() {
            @Override
            public List<String> execute(Transaction transaction) {
                List<String> results = new LinkedList<>();
                Result result1 = transaction.run(cql);
                while (result1.hasNext()) {
                    List<Pair<String, Value>> fields1 = result1.next().fields();
                    System.out.println(fields1.toString());
                    results.add(fields1.get(0).value().toString());
                }
                return results;
            }
        }) ;
        return result;
    }

    public void destory(){
        session.close();
    }
}
