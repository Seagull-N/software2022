package com.example.airconditioner.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; 

import com.example.airconditioner.entity.Vote;
import com.example.airconditioner.form.VoteForm;
import com.example.airconditioner.repository.VoteRepository;


@Service
public class VoteService {
    @Autowired
    VoteRepository vRepo;

    /**
     * 投票を作成する
     * 
     */
    public Vote createVote(String cid, String uid, VoteForm form) {
        if (vRepo.findByUidAndCid(uid, cid) != null) {
            Vote v = vRepo.findByUidAndCid(uid, cid);
            v.setEcaluation(form.getEvaluation());

            return vRepo.save(v);
        }
        


        Vote v = form.toEntity();
        return vRepo.save(v);
    }

    /**
     * 授業ごとの投票一覧を取得する
     * @return
     */
    public List<Vote> getVotes(String cid) {
        
        return vRepo.findByCid(cid);
    }
}
