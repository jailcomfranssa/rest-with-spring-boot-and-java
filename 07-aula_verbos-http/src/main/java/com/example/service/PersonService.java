package com.example.service;

import com.example.model.Person;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();
    private final Logger logger = Logger.getLogger(PersonService.class.getName());

    public Person findbyId(String id){
        logger.info("Finding one person!");
        Person person = new Person();

        person.setId(counter.incrementAndGet());
        person.setFirstName("Jailson");
        person.setLastName("França");
        person.setAddress("João Pessoa - PB");
        person.setGender("Male");

        return person;

    }

}
