package com.gai.utils;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class JedisUtils {
    private Jedis jedis;

    public JedisUtils(Jedis jedis){
        this.jedis = jedis;
    }

    //操作String的方法
    public String setString(String key,String value){
        return jedis.set(key, value);
    }

    public String getString(String key){
        return jedis.get(key);
    }

    //操作Hash方法
    public String setHash(String hashName, HashMap values){
        return jedis.hmset(hashName,values);
    }

    public String getHash(String hashName,String key){
        return jedis.hget(hashName, key);
    }

    //操作List
    public Long lpush(String key,String... values){
        return jedis.lpush(key, values);
    }

    public Long rpush(String key,String... values){
        return jedis.rpush(key, values);
    }

    public List lrange(String key,Long start,Long end){
        return jedis.lrange(key,start,end);
    }

    //操作Set
    public Long sadd(String key,String... members){
        return jedis.sadd(key, members);
    }

    public Set smembers(String key){
        return jedis.smembers(key);
    }

    //操作ZSet
    public Long zadd(String key,double score,String member){
        return jedis.zadd(key, score, member);
    }

    public Set zrangeByScore(String key,double min,double max){
        return jedis.zrangeByScore(key, min, max);
    }
}
