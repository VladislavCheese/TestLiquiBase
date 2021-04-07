package com.example.testliquibase.controllers;

import com.example.testliquibase.entity.PeopleEntity;
import com.example.testliquibase.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SpringController {
    private PeopleService peopleService;

    @Autowired
    public void setPeopleService(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping("/people")
    public List<PeopleEntity> showAllPeople(){
        return peopleService.getAllPeople();
    }

    @GetMapping("/people/{id}")
    public PeopleEntity getPerson(@PathVariable int id){
        PeopleEntity person = peopleService.getPerson(id);
        return person;
    }

    @PostMapping("/people")
    public PeopleEntity addNewPerson(@RequestBody PeopleEntity person){
        peopleService.savePerson(person);
        return person;
    }

    @PutMapping("/people")
    public PeopleEntity updatePerson(@RequestBody PeopleEntity person){
        peopleService.savePerson(person);
        return person;
    }

    @DeleteMapping("/people/{id}")
    public String deletePerson(@PathVariable int id){
        peopleService.deletePerson(id);
        return "Person with ID = " + id + " was deleted";
    }
}
