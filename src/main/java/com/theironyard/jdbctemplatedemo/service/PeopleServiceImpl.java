package com.theironyard.jdbctemplatedemo.service;

import com.theironyard.jdbctemplatedemo.entity.Person;
import com.theironyard.jdbctemplatedemo.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeopleServiceImpl implements PeopleService {


    private final PeopleRepository peopleRepository;

    @Autowired
    public PeopleServiceImpl(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @Override
    public List<Person> listPeople(String search){
        return peopleRepository.listPeople(search);
    }

    @Override
    public void savePerson(Person person){
        peopleRepository.savePerson(person);
    }

}
