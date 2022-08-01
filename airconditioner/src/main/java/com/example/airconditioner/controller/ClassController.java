package com.example.airconditioner.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.airconditioner.form.ClassForm;
import com.example.airconditioner.entity.Class;
import com.example.airconditioner.service.ClassService;

@Controller
@RequestMapping
public class ClassController {
    @Autowired
   ClassService cService;

   @GetMapping("/create/{uid}")
   String showClassForm(Model model) {
        ClassForm form = new ClassForm();
        model.addAttribute("ClassForm", form);

        return "create";
   }
}
