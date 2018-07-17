package com.iny;


import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.search.MultiMatchQuery;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by zcy on 2018/5/14.
 */
public class es {

    private static Client client;

    public  es(){


    }

    public static void main(String[] args) {


        try {
            //初始化client
            Settings settings = Settings.builder()
                    .put("client.transport.sniff", true)
                    .put("cluster.name", "my-application").build();
            client= new PreBuiltTransportClient(settings)
                    .addTransportAddress( new InetSocketTransportAddress(InetAddress.getByName("localhost"),9300));

            //通过get获取咨询
            // GetResponse response = client.prepareGet("items","item","慧")
            //       .get();

            QueryBuilder qb = QueryBuilders.boolQuery().must(QueryBuilders.fuzzyQuery("itemName","二"));

            SearchResponse response = client.prepareSearch("items").setTypes("item").setQuery(qb).get();

            System.out.print(response.toString());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }finally {
            if(client != null){
                client.close();
            }
        }
    }

    public static void getQuery(){

        GetResponse response = client.prepareGet("items","item","sJDOTWMBbSHGFyHCmKgj")
                .get();
        System.out.print(response.toString());
        client.close();
    }
}
