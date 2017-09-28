package com.theironyard.jdbctemplatedemo.service;

import com.theironyard.jdbctemplatedemo.entity.Person;
import com.theironyard.jdbctemplatedemo.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeopleService {


    private final PeopleRepository peopleRepository;

    @Autowired
    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public List<Person> listPeople(String search){
        return peopleRepository.listPeople(search);
    }

    public void savePerson(Person person){
        peopleRepository.savePerson(person);
    }

}
