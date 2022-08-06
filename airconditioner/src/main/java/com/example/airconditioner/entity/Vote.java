package com.example.airconditioner.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Vote {
    public Vote(String evaluation) {
    }

    public Vote() {
    }

    @Id
    @GeneratedValue
    Long seq;
    String evaluation;
    String cid;
    String uid;
}