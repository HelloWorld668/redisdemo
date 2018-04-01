package com.xc.redisdemo;

import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;

public class RedisJava {
    /**
     * bind 127.0.0.1
     */
    public static void main(String[] args) {
        Jedis jedis = new Jedis("ip");
        jedis.auth("test123");  
        System.out.println("连接成功");
        //查看服务是否运行
        System.out.println("服务正在运行: "+jedis.ping());
        
        jedis.set("runoobkey", "www.runoob.com");
        jedis.get("runoobkey");

        jedis.lpush("site-list", "Runoob");
        jedis.lpush("site-list", "Google");
        jedis.lpush("site-list", "Taobao");
        List<String> list = jedis.lrange("site-list", 0 ,2);

        Set<String> keys = jedis.keys("*");
    }
}
