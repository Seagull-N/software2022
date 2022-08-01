package com.example.airconditioner.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class Vote {
    @Id
    @GeneratedValue
    Long seq;
    @NonNull
    String evaluation;
    String cid;
    String uid;
}