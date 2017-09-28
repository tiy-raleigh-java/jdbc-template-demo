package com.theironyard.jdbctemplatedemo.controller;

import com.theironyard.jdbctemplatedemo.entity.Person;
import com.theironyard.jdbctemplatedemo.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PeopleController {

    private final PeopleService peopleService;

    @Autowired
    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping("/")
    public String listPeople(Model model, @RequestParam(defaultValue = "") String search){

        model.addAttribute("people", peopleService.listPeople(search));
        model.addAttribute("search", search);

        return "index";
    }

    @GetMapping("/personForm")
    public String showPersonForm(){
        return "personForm";
    }

    @PostMapping("/savePerson")
    public String savePerson(Person person){

        peopleService.savePerson(person);

        return "redirect:/";
    }
}
