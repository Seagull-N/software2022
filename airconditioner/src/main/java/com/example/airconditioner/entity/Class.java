package com.example.airconditioner.entity;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Class {
    @Id
    String cid;
    Date StartTime;
    Date endTime;
    String className;
}
