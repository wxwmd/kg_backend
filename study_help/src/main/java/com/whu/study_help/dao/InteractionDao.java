package com.whu.study_help.dao;

import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InteractionDao {
    RestHighLevelClient client;

    public InteractionDao(){
        RestClientBuilder builder = RestClient.builder(
                new HttpHost(
                        "127.0.0.1",  //es主机 IP
                        9200   // es 端口http
                )
        );
        client = new RestHighLevelClient(builder);
    }

    public List<Map<String,Object>> getInteractions(String word){
        System.out.println(word);
        // new 一个SearchRequest
        SearchRequest searchRequest=new SearchRequest("interaction");
        searchRequest.types("doc");

        // new 一个SearchSourceBuilder，指定要查找什么
        SearchSourceBuilder searchSourceBuilder=new SearchSourceBuilder();
        MatchQueryBuilder matchQueryBuilder=new MatchQueryBuilder("问题",word);
        matchQueryBuilder.fuzziness(Fuzziness.AUTO);
        searchSourceBuilder.query(matchQueryBuilder);
        //将这个SearchSourceBuilder安到SearchRequest上
        searchRequest.source(searchSourceBuilder);

        //当针对不存在的索引执行获取请求时，响应404状态码，将引发IOException，需要按如下方式处理：
        SearchResponse interactionFields = null;
        try {
            interactionFields = client.search(searchRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Map<String,Object>> interactions=new ArrayList<>();
        SearchHits hits = interactionFields.getHits();
        for (SearchHit hit:hits){
            Map<String, Object> interaction = hit.getSourceAsMap();
            interactions.add(interaction);
        }

        return interactions;
    }

    public void destory(){
        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
