package com.yangxvhao.demo;

import redis.clients.jedis.Jedis;

/**
 * @author yangxvhao
 * @date 17-12-19.
 */

public class Main {
    public static void main(String[] args) {
//        JedisCluster jedisCluster = new JedisCluster("127.0.0.1","password","");
        Jedis jedis = new Jedis("127.0.0.1");
        jedis.set("111","222");
    }

}
