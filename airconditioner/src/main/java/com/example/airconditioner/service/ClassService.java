package com.example.airconditioner.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; 

import com.example.airconditioner.form.ClassForm;
import com.example.airconditioner.entity.Class;
import com.example.airconditioner.repository.ClassRepository;

@Service
public class ClassService {
    @Autowired
    ClassRepository cRepo;

    /**
     * クラスをを作成する
     */
    public Class createUser(ClassForm form) {
        Class c = form.toEntity();

        return cRepo.save(c);
    }

    /**
     * クラスを取得する
     * @return
     */
    public Class getClass(String cid) {
        return cRepo.findById(cid).get();
    }
}
