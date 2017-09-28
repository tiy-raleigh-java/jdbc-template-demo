package com.theironyard.jdbctemplatedemo.repository;

import com.theironyard.jdbctemplatedemo.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PeopleRepositoryImpl implements PeopleRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PeopleRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Person> listPeople(String search){
        return jdbcTemplate.query(
                //"SELECT firstname, lastname FROM person WHERE firstname = '"  + search + "' LIMIT 100", <--- don't!!!
                "SELECT firstname, lastname FROM person WHERE (firstname = ? OR lastname = ?) OR ? = ''  LIMIT 100",
                (resultSet, i) -> new Person(resultSet.getString("firstname"), resultSet.getString("lastname")),
                search, search, search);

    }

    @Override
    public void savePerson(Person person) {
        jdbcTemplate.update("INSERT INTO person (firstname, lastname) VALUES (?, ?)", person.getFirstName(), person.getLastName());
    }

}
