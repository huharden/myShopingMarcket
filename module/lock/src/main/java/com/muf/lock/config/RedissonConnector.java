package com.muf.lock.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Description:
 *
 * @author: hutao
 * Date: 2019-02-22-16:49
 */
@Component
public class RedissonConnector {
    /*@Value("${spring.redis.host}")
    private String redisUrl ;*/

    RedissonClient redisson;

    @PostConstruct
    public void init(){
        //redisson = Redisson.create();
        Config config = new Config();
        config.useSingleServer().setAddress("redis://123.207.27.144:6379");
        redisson = Redisson.create(config);
    }

    public RedissonClient getClient(){
        return redisson;
    }
}
