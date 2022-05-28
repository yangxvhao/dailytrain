package com.yangxvhao.demo.proxy;

import redis.clients.jedis.Jedis;

/**
 * @author yangxvhao
 * @date 17-12-19.
 */

public class Main {
    public static void main(String[] args) {
//        JedisCluster jedisCluster = new JedisCluster("127.0.0.1","password","");
//        JedisPoolConfig poolConfig = new JedisPoolConfig();
//        JedisPool pool = new JedisPool("127.0.0.1",6379);
        Jedis jedis = new Jedis("127.0.0.1",6379);
        jedis.auth("123456");
//        System.out.println(jedis.ping());
        System.out.println(jedis.get("number1"));
    }

}
