package com.example.airconditioner.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.airconditioner.entity.User;//変える

@Repository
public interface UserRepository extends CrudRepository<User, String>{  
    List<User> findAll();
}   