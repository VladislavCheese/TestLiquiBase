package com.example.testliquibase.dao;

import com.example.testliquibase.entity.PeopleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class PeopleDAOImpl implements PeopleDAO {

    private EntityManager entityManager;

    @Autowired
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<PeopleEntity> getAllPeople() {
        Query query = entityManager.createQuery("FROM PeopleEntity");
        List<PeopleEntity> result = query.getResultList();
        return result;
    }

    @Override
    public void savePerson(PeopleEntity person) {
        PeopleEntity peopleEntity = entityManager.merge(person);
        person.setPeopleId(peopleEntity.getPeopleId());
    }

    @Override
    public PeopleEntity getPerson(int peopleId) {
        PeopleEntity person = entityManager.find(PeopleEntity.class, peopleId);
        return person;
    }

    @Override
    public void deletePerson(int personId) {
//   =
        Query query = entityManager.createQuery("DELETE FROM PeopleEntity WHERE peopleId "
                + "= : currentPerson");
        query.setParameter("currentPerson", personId);
        query.executeUpdate();
    }
}
