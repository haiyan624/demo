package com.wq.cache;

import lombok.Setter;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Collection;
import java.util.Set;

@Setter
public class MyShiroCache implements Cache {

    private String name;

    private RedisTemplate redisTemplate;

    public MyShiroCache() {

    }

    public MyShiroCache(String name) {
        this.name = name;
    }

    @Override
    public Object get(Object o) throws CacheException {
        System.out.println("shiro 从redis中获取" + o.toString());
        Object value = redisTemplate.opsForValue().get(name + o.toString());
        if (value == null) {
            System.out.println("未命中");
            return null;
        } else {
            System.out.println("命中，值为：" + value);
            return value;
        }
    }

    @Override
    public Object put(Object o, Object o2) throws CacheException {
        System.out.println("放值：" + o.toString());
        redisTemplate.opsForValue().set(name + o.toString(), o2);
        return null;
    }

    @Override
    public Object remove(Object o) throws CacheException {
        System.out.println("移除值：" + o.toString());
        redisTemplate.delete(name + o.toString());
        return null;
    }

    // 忽略
    public void clear() throws CacheException {
        System.out.println("clear~~");
    }

    // 忽略
    public int size() {
        System.out.println("size~~~~~~~~");
        return 0;
    }

    // 忽略
    public Set keys() {
        System.out.println("keys~~~~`");
        return null;
    }

    // 忽略
    public Collection values() {
        System.out.println("values~~~~~~");
        return null;
    }
}
