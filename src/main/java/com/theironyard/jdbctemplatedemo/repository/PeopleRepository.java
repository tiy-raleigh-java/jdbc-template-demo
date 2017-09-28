package com.theironyard.jdbctemplatedemo.repository;

import com.theironyard.jdbctemplatedemo.entity.Person;

import java.util.List;

/**
 * Created by doug on 9/28/17.
 */
public interface PeopleRepository {
    List<Person> listPeople(String search);
    void savePerson(Person person);
}
