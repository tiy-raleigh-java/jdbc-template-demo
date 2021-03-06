package com.theironyard.jdbctemplatedemo.service;

import com.theironyard.jdbctemplatedemo.entity.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PeopleServiceImplTest {

    @Autowired
    PeopleService peopleServiceImpl;

    @Test
    public void listPeopleTest() throws Exception {
        // arrange

        // act
        List<Person> people = peopleServiceImpl.listPeople("");

        // assert
        assertEquals(100, people.size());
    }

    @Test
    public void whenPersonIsSavedThenPersonIsInDatabase(){
        // act
        peopleServiceImpl.savePerson(new Person("Phil", "Philson"));

        // assert
        List<Person> people = peopleServiceImpl.listPeople("Philson");
        assertTrue(people.size() > 0);



    }

}