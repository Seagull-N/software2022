package com.example.airconditioner.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.airconditioner.entity.Vote;//変える

@Repository
public interface VoteRepository extends CrudRepository<Vote, String>{  
    Vote findByUidAndCid(String uid, String cid);
    List<Vote> findByCid(String cid);
}   