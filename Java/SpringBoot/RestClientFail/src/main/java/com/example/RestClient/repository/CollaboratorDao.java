package com.example.RestClient.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.example.RestClient.models.CollaboratorRp2;

@Repository
public class CollaboratorDao {
	public static final String HASH_KEY = "Collaborator";
    @Autowired
    private RedisTemplate template;
    
    public CollaboratorRp2 save(CollaboratorRp2 collaborator) {
    	template.opsForHash().put(HASH_KEY, collaborator.getId(), collaborator);
    	
    	return collaborator;
    }
    
    public List<CollaboratorRp2> findAll(){
        return template.opsForHash().values(HASH_KEY);
    }
}
