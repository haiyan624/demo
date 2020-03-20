package com.wq.cache;

import lombok.Getter;
import lombok.Setter;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Setter
@Getter
public class MyShiroSessionDao extends AbstractSessionDAO {

    private RedisTemplate redisTemplate;


    @Override
    protected Serializable doCreate(Session session) {
        //生成sessionId
        Serializable sessionId = generateSessionId(session);
        System.out.println("save sessionId to reids");

        // sessionId赋值给session对象
        assignSessionId(session,sessionId);
        redisTemplate.opsForValue().set("sessionId"+sessionId,session,10, TimeUnit.SECONDS);
        return sessionId;
    }

    @Override
    protected Session doReadSession(Serializable serializable) {
        Session session = (Session) redisTemplate.opsForValue().get("sessionId"+serializable);
        //更新最后一次访问
        redisTemplate.expire("sessionId"+serializable,10,TimeUnit.SECONDS);
        return session;
    }

    @Override
    public void update(Session session) throws UnknownSessionException {
        System.out.println("update session:"+session.getId());
        redisTemplate.opsForValue().set("sessionId"+session.getId(),session,10, TimeUnit.SECONDS);
    }

    @Override
    public void delete(Session session) {
        System.out.println("delete session :" + session.getId());
        redisTemplate.delete("sessionId"+session.getId());
    }

    @Override
    public Collection<Session> getActiveSessions() {
        Set keys = redisTemplate.keys("sessionId");
        List<Session> list = redisTemplate.opsForValue().multiGet(keys);
        return list;
    }
}
