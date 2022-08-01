package com.example.airconditioner.controller;
import javax.validation.constraints.Null;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.airconditioner.form.ClassForm;
import com.example.airconditioner.entity.Class;
import com.example.airconditioner.service.ClassService;

@Controller
@RequestMapping
public class ClassController {
    @Autowired
   ClassService cService;

   @GetMapping("/create/{uid}")
   String showClassForm(@PathVariable("uid") String uid,Model model) {
        ClassForm form = new ClassForm();
        model.addAttribute("ClassForm", form);
        model.addAttribute("uid", uid);

        return "create";
   }

   @PostMapping("/create/{uid}")
   String createClass(@PathVariable("uid") String uid, @ModelAttribute(name = "ClassForm") ClassForm form, Model model) {
          Class c = cService.createClass(form);

          return "redirect:/result/" + uid + "/" + c.getCid();
   }

   @GetMapping("result/{uid}/{cid}")
   String showResult(@PathVariable("cid") String cid, Model model) {
          model.addAttribute("hot", 3);
          model.addAttribute("normal", 1);
          model.addAttribute("cold", 5);
          model.addAttribute("cid", cid);

          return "result";
   }

   @GetMapping("enter/{uid}")
   String showEnterForm(@PathVariable("uid") String uid, Model model) {
          model.addAttribute("uid", uid);

          return "enter";
   }

   @GetMapping("search/{uid}")
   String enterClass(@RequestParam("cid") String cid, @PathVariable("uid") String uid, Model model) {
          if(cService.getClass(cid) == null) {
               return "redirect:/enter" + uid;
          }

          return "redirect:/vote/" + uid + "/" + cid;
   }
}
