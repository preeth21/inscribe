package com.tony.inscribe.controller;

import com.tony.inscribe.model.Person;
import com.tony.inscribe.model.PersonRegDto;
import com.tony.inscribe.service.PersonServiceImp;
import jakarta.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class PersonRegController {

    @Autowired
    private PersonServiceImp personService;


    @ModelAttribute("person")
    public PersonRegDto userRegistrationDto() {
        return new PersonRegDto();
    }

    @GetMapping
    public String showRegistrationForm() {
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") PersonRegDto registrationDto) {

        personService.save(registrationDto);
        return "redirect:/registration?success";
    }
}
