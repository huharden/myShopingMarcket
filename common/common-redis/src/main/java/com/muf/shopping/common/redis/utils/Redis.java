package com.muf.shopping.common.redis.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Description:
 *
 * @author: hutao
 * Date: 2019-01-14-14:47
 */
@Component
public class Redis {

    @Autowired
    private StringRedisTemplate template;

    public void set(String key, String value, long expire){
        template.opsForValue().set(key, value, expire, TimeUnit.SECONDS);
    }

    public void set(String key, String value){
        template.opsForValue().set(key, value);
    }

    public Object get(String key){
        return template.opsForValue().get(key);
    }

    public  void delete(String key){
        template.delete(key);
    }

}
