package com.muf.shopping.common.redis.utils;


import com.google.gson.reflect.TypeToken;
import com.muf.shopping.common.base.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Redis工具类
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-07-17 21:12
 */
@Component
public class RedisUtils {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private ValueOperations<String, String> valueOperations;

    /**
     * 默认过期时长，单位：秒
     */
    private final static long DEFAULT_EXPIRE = 60 * 60 * 24;
    /**
     * 不设置过期时长
     */
    private final static long NOT_EXPIRE = -1;

    /**
     * 设置键值对，并设置TTL
     */
    public void set(String key, Object value, long expire) {
        valueOperations.set(key, toJson(value));
        if (expire != NOT_EXPIRE) {
            redisTemplate.expire(key, expire, TimeUnit.SECONDS);
        }
    }

    public void set(String key, Object value, Date date) {
        valueOperations.set(key, toJson(value));
        if (date != null) {
            redisTemplate.expireAt(key, date);
        }
    }

    /**
     * 设置键值对，默认TTL
     */
    public void set(String key, Object value) {
        set(key, value, DEFAULT_EXPIRE);
    }

    /**
     * 获取对象，并设置TTL
     */
    public <T> T get(String key, Class<T> clazz, long expire) {
        String value = valueOperations.get(key);
        if (expire != NOT_EXPIRE) {
            redisTemplate.expire(key, expire, TimeUnit.SECONDS);
        }
        return value == null ? null : fromJson(value, clazz);
    }

    /**
     * 获取对象
     */
    public <T> T get(String key, Class<T> clazz) {
        return get(key, clazz, NOT_EXPIRE);
    }

    /**
     * TypeToken 获取对象，并设置TTL
     */
    public <T> T get(String key, TypeToken typeToken, long expire) {
        String value = valueOperations.get(key);
        if (expire != NOT_EXPIRE) {
            redisTemplate.expire(key, expire, TimeUnit.SECONDS);
        }
        return value == null ? null : JsonUtil.fromJson(value, typeToken.getType());
    }

    /**
     * TypeToken 获取对象
     */
    public <T> T get(String key, TypeToken typeToken) {
        return get(key, typeToken, NOT_EXPIRE);
    }

    /**
     * 获取value字符串，并设置TTL
     */
    public String get(String key, long expire) {
        String value = valueOperations.get(key);
        if (expire != NOT_EXPIRE) {
            redisTemplate.expire(key, expire, TimeUnit.SECONDS);
        }
        return value;
    }

    /**
     * 获取value字符串
     */
    public String get(String key) {
        return get(key, NOT_EXPIRE);
    }

    /**
     * 删除key
     */
    public void delete(String key) {
        redisTemplate.delete(key);
    }

    /**
     * 清除以key为前缀的所有ke
     */
    public String cleanKeys(String key) {
        Set<String> keys = redisTemplate.keys(key);
        for (String k : keys) {
            redisTemplate.delete(k);
        }
        return keys.toString();
    }

    //模糊查询key
    public String fuzzyKey(String key) {
        Set<String> keySet = redisTemplate.keys(key + "*");
        Iterator iter = keySet.iterator();
        while (iter.hasNext()) {
            return iter.next().toString();
        }
        return "";
    }
    /**
     * 获取以key为前缀的所有key
     */
    public Set<String> getKeys(String key) {
        return redisTemplate.keys(key);
    }

    /**
     * Object转成JSON数据
     */
    private String toJson(Object object) {
        if (object instanceof Integer || object instanceof Long || object instanceof Float ||
                object instanceof Double || object instanceof Boolean || object instanceof String) {
            return String.valueOf(object);
        }
        return JsonUtil.toJson(object);
    }

    /**
     * JSON数据，转成Object
     */
    private <T> T fromJson(String json, Class<T> clazz) {
        return JsonUtil.fromJson(json, clazz);
    }

    /**
     * 清除key
     */
    public String cleanKey(String key) {
        Set<String> keys = redisTemplate.keys(key);
        for (String k : keys) {
            redisTemplate.delete(k);
        }
        return keys.toString();
    }

    public long increment(String key) {
        return valueOperations.increment(key, 1L);
    }
}
