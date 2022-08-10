package com.example.airconditioner.form;

import com.example.airconditioner.entity.User;
import lombok.Data;
@Data
public class UserForm {
    String uid;
    String role;

    public User toEntity() {
        User u = new User(uid, role, "");
        return u;
    }
}