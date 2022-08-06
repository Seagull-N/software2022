package com.example.airconditioner.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            v.setEvaluation(form.getEvaluation());
            System.out.println("hohheefwakfe");
            return vRepo.save(v);
        }

        Vote v = form.toEntity();
        v.setCid(cid);
        v.setUid(uid);
        System.out.println("adfas");
        return vRepo.save(v);

    }

    /**
     * 授業ごとの投票一覧を取得する
     * 
     * @return
     */
    public List<Vote> getVotes(String cid) {

        return vRepo.findByCid(cid);
    }

    public Map<String, Integer> getEvaluations(String cid) {
        Map<String, Integer> votes = new HashMap();
        votes.put("HOT", vRepo.findByCidAndEvaluation(cid, "HOT").size());
        votes.put("NORMAL", vRepo.findByCidAndEvaluation(cid, "NORMAL").size());
        votes.put("COLD", vRepo.findByCidAndEvaluation(cid, "COLD").size());
        return votes;
    }
}
