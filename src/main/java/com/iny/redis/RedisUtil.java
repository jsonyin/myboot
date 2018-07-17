package com.iny.redis;

import redis.clients.jedis.Jedis;

/**
 * Created by zcy on 2018/1/15.
 */
public class RedisUtil {

    private Jedis jedis;

    public RedisUtil(Jedis jedis){

        this.jedis=jedis;
    }

    public Object setString(String key,String value){
        return jedis.append(key,value);
    }

    public Object setList(String key,String... var2){
        return jedis.lpush(key,var2);
    }


}
