package com.example.airconditioner.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Vote {
    @Id
    Long seq;
    String ecaluation;
    String cid;
    String uid;
}