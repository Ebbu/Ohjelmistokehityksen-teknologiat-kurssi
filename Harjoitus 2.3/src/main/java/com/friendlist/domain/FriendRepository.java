package com.friendlist.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;



public interface FriendRepository extends CrudRepository<Friend, Long> {

    List<Friend> findByName(String Name);
    
}