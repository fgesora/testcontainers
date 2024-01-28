package com.gesora.testcontainers;

import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {
    private final JdbcClient jdbcClient;

    public PersonController(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    @PostMapping
    void post(@RequestBody Person person){
        jdbcClient.sql("insert into person (name) values (?)")
                .param(person.name())
                .update();
    }

    @GetMapping
    List<Person> get(){
        return jdbcClient.sql("select * from person")
                .query(Person.class)
                .list();
    }
}
