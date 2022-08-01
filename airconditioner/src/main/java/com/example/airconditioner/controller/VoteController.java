package com.example.airconditioner.controller;
import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.airconditioner.form.VoteForm;
import com.example.airconditioner.entity.Vote;
import com.example.airconditioner.service.VoteService;

@Controller
@RequestMapping("/")
public class VoteController {
   @Autowired
   VoteService vService;

   @GetMapping("/vote/{uid}/{cid}")
   String showVoteForm(@PathVariable("uid") String uid, @PathVariable("cid") String cid, Model model) {
        VoteForm form = new VoteForm();
        model.addAttribute("VoteForm", form);
        model.addAttribute("uid", uid);
        model.addAttribute("cid", cid);

        return "vote";
   }

   @PostMapping("/vote/{uid}/{cid}")
   String createVote(@PathVariable("uid") String uid, @PathVariable("cid") String cid, @ModelAttribute(name = "VoteForm") VoteForm form, Model model) {
        //vService.createVote(cid, uid, form);

        return "redirect:/voted/" + uid + "/" + cid;
   }

   @GetMapping("/voted/{uid}/{cid}")
   String showVoted(@PathVariable("uid") String uid, @PathVariable("cid") String cid, Model model) {
        model.addAttribute("uid", uid);
        model.addAttribute("cid", cid);

        return "voted";
   }
}
