package com.theironyard.jdbctemplatedemo.service;

import com.theironyard.jdbctemplatedemo.entity.Person;

import java.util.List;

/**
 * Created by doug on 9/28/17.
 */
public interface PeopleService {
    List<Person> listPeople(String search);

    void savePerson(Person person);
}
