package com.example.airconditioner.form;

import com.example.airconditioner.entity.Vote;
import lombok.Data;
@Data
public class VoteForm {
    String evaluation;

    public Vote toEntity() {
        Vote v = new Vote(evaluation);
        return v;
    }
}