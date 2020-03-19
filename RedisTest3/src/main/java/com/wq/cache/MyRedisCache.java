package com.wq.cache;

import org.apache.ibatis.cache.Cache;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.context.ContextLoader;

import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MyRedisCache implements Cache {
    private String id;
    private ReadWriteLock readWriteLock;
    private RedisTemplate template;

    public MyRedisCache() {
    }

    public MyRedisCache(String id) {
        this.id = id;
        this.readWriteLock = new ReentrantReadWriteLock();
    }

    @Override
    public String getId() {
        return this.id;
    }

    // 忽略
    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public void putObject(Object o, Object o1) {
        System.out.println("放入缓存："+o.toString()+"---"+o1.toString());
        ValueOperations<String, Object> valueOperations = template.opsForValue();
        valueOperations.set(o.toString(),o1);
    }

    @Override
    public Object getObject(Object o) {
        System.out.println("开始查询"+o);
        template = (RedisTemplate) ContextLoader.getCurrentWebApplicationContext().getBean("redisTemplate");
        ValueOperations<String, Object> valueOperations = template.opsForValue();
        Object value = valueOperations.get(o.toString());
        if(value==null){
            System.out.println("未查询到");
            return null;
        } else{
            System.out.println("命中缓存");
            return value;
        }
    }

    @Override
    public Object removeObject(Object o) {
        template.delete(o.toString());
        return null;
    }

    @Override
    public void clear() {
        System.out.println("执行清空操作"+this.id);
        template = (RedisTemplate) ContextLoader.getCurrentWebApplicationContext().getBean("redisTemplate");
        Set keys = template.keys("*" + this.id + "*");
        template.delete(keys);
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return this.readWriteLock;
    }
}
