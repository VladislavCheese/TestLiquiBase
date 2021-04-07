package com.example.testliquibase.dao;

import com.example.testliquibase.entity.PeopleEntity;

import java.util.List;

public interface PeopleDAO {
    List<PeopleEntity> getAllPeople();

    void savePerson(PeopleEntity person);

    PeopleEntity getPerson(int peopleId);

    void deletePerson(int personId);
}
