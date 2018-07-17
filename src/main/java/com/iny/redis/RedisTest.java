package com.iny.redis;

import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * Created by zcy on 2018/1/15.
 */
public class RedisTest {
    public static void main(String args[]){
        //RedisUtil ru = new RedisUtil(new Jedis("127.0.0.1",6379));
        //ru.setList("alist","a","b","c");

        Jedis js  = new Jedis("127.0.0.1",6379);
        //js.lpush("alist","123");
        List<String> s = js.lrange("alist",1,1);
        //s(()->System.out.println(s));

    }
}
