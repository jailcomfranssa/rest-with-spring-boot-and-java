package com.example.service;

import com.example.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();
    private final Logger logger = Logger.getLogger(PersonService.class.getName());

    public List<Person> findAll(){
        logger.info("Finding all person!");
        List<Person> persons = new ArrayList<>();
        for(int i =0; i<8; i++){
            Person person = mockPerson(i);
            persons.add(person);

        }
        return persons;
    }



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

    private Person mockPerson(int i) {

        Person person = new Person();

        person.setId(counter.incrementAndGet());
        person.setFirstName("Person name "+i);
        person.setLastName("Person LastName "+i);
        person.setAddress("Person Address "+i);
        person.setGender("Person Gender" +i);

        return person;
    }






















}
