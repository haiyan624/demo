package com.wq.cache;

import lombok.Setter;
import org.apache.shiro.cache.AbstractCacheManager;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.springframework.data.redis.core.RedisTemplate;

@Setter
public class MyShiroCacheManager extends AbstractCacheManager {

    private RedisTemplate redisTemplate;

    @Override
    protected Cache createCache(String s) throws CacheException {
        MyShiroCache cache = new MyShiroCache(s);
        cache.setRedisTemplate(redisTemplate);
        return cache;
    }
}
