package com.example.airconditioner.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.airconditioner.entity.Class;//変える

@Repository
public interface ClassRepository extends CrudRepository<Class, String>{  
}   