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

import com.example.airconditioner.form.UserForm;
import com.example.airconditioner.entity.User;
import com.example.airconditioner.service.UserService;

@Controller
@RequestMapping("/")
public class UserController {
   @Autowired
   UserService uService;

   @GetMapping("/")
   String showUserForm(Model model) {
        UserForm form = new UserForm();
        model.addAttribute("UserForm", form);

        return "login";
   }

   @PostMapping("/")
   String login(@ModelAttribute(name = "UserForm") UserForm form, Model model) {
        User u = uService.createUser(form);

        if (u.getRole().equals("TEACHER")) {
            return "redirect:/create/" + u.getUid();
        }

        return "redirect:/enter" + u.getUid();
   }
}
