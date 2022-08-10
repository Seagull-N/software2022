package com.example.airconditioner.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; 

import com.example.airconditioner.form.UserForm;
import com.example.airconditioner.entity.User;
import com.example.airconditioner.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository uRepo;

    /**
     * Userを作成する
     * 既に存在する場合は作成せず、既存ユーザを返す
     */
    public User createUser(UserForm form) {
        String uid = form.getUid();

        if (uRepo.existsById(uid)) {
            User u = uRepo.findById(uid).get();
            return u;
        }

        User u = form.toEntity();

        return uRepo.save(u);
    }

    /**
     * 全ユーザを取得する
     * @return
     */
    public List<User> getAllUsers() {
        return uRepo.findAll();
    }
}
