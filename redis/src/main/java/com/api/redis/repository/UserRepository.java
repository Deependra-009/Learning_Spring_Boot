package com.api.redis.repository;

import com.api.redis.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class UserRepository {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    private static final String KEY="USER_KEY_REDIS";

    public User saveUser(User user){
        redisTemplate.opsForHash().put(KEY,user.getUserID(),user);
        return user;
    }

    public User getUser(String id){
        return (User)redisTemplate.opsForHash().get(KEY,id);
    }

    public Map<Object,Object> getAll(){
        return redisTemplate.opsForHash().entries(KEY);
    }

    public void delete(String id){
        redisTemplate.opsForHash().delete(KEY,id);
    }

}
