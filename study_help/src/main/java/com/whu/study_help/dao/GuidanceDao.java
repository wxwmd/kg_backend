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

public class GuidanceDao {
    RestHighLevelClient client;

    public GuidanceDao(){
        RestClientBuilder builder = RestClient.builder(
                new HttpHost(
                        "127.0.0.1",  //es主机 IP
                        9200   // es 端口http
                )
        );
        client = new RestHighLevelClient(builder);
    }

    public List<Map<String,Object>> getGuidances(String word){
        System.out.println(word);
        // new 一个SearchRequest
        SearchRequest searchRequest=new SearchRequest("guidance");
        searchRequest.types("doc");

        // new 一个SearchSourceBuilder，指定要查找什么
        SearchSourceBuilder searchSourceBuilder=new SearchSourceBuilder();
        MatchQueryBuilder matchQueryBuilder=new MatchQueryBuilder("名称",word);
        matchQueryBuilder.fuzziness(Fuzziness.AUTO);
        searchSourceBuilder.query(matchQueryBuilder);
        //将这个SearchSourceBuilder安到SearchRequest上
        searchRequest.source(searchSourceBuilder);

        //当针对不存在的索引执行获取请求时，响应404状态码，将引发IOException，需要按如下方式处理：
        SearchResponse guidanceFields = null;
        try {
            guidanceFields = client.search(searchRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Map<String,Object>> guidances=new ArrayList<>();
        SearchHits hits = guidanceFields.getHits();
        for (SearchHit hit:hits){
            Map<String, Object> guidance = hit.getSourceAsMap();
            guidances.add(guidance);
        }

        return guidances;
    }

    public void destory(){
        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
