package com.example.services;

import com.example.controller.PersonController;
import com.example.data.vo.v1.PersonVO;
import com.example.data.vo.v2.PersonVOV2;
import com.example.exceptions.RequiredObjectIsNullException;
import com.example.exceptions.ResourceNotFoundException;
import com.example.mapper.DozerMapper;
import com.example.mapper.custom.PersonMapper;
import com.example.model.Person;
import com.example.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@Service
public class PersonServices {

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;

    @Autowired
    PersonMapper personMapper;

    public List<PersonVO> findAll() {

        logger.info("Finding all people!");

        var persons = DozerMapper.parseListObjects(repository.findAll(), PersonVO.class);
        persons.forEach(p-> p.add(linkTo(methodOn(PersonController.class).findbyId(p.getId())).withSelfRel()));
        return persons;
    }

    public PersonVO findById(Long id) {

        logger.info("Finding one person!");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        PersonVO vo = DozerMapper.parseObject(entity, PersonVO.class);
        vo.add(linkTo(methodOn(PersonController.class).findbyId(id)).withSelfRel());

        return vo;
    }

    public PersonVO create(PersonVO person) {

        if(person == null){
            throw new RequiredObjectIsNullException();
        }

        logger.info("Creating one person!");
        var entity = DozerMapper.parseObject(person, Person.class);
        var vo =  DozerMapper.parseObject(repository.save(entity), PersonVO.class);
        vo.add(linkTo(methodOn(PersonController.class).findbyId(vo.getId())).withSelfRel());

        return vo;
    }

    public PersonVOV2 createV2(PersonVOV2 person) {

        logger.info("Creating one person V2!");
        var entity = personMapper.convertVoToEntity(person);
        var vo =  personMapper.convertEntityToVo(repository.save(entity));
        return vo;
    }


    public PersonVO update(PersonVO person) {

        if(person == null){
            throw new RequiredObjectIsNullException();
        }

        logger.info("Updating one person!");

        var entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        var vo =  DozerMapper.parseObject(repository.save(entity), PersonVO.class);
        vo.add(linkTo(methodOn(PersonController.class).findbyId(vo.getId())).withSelfRel());

        return vo;
    }

    public void delete(Long id) {

        logger.info("Deleting one person!");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        repository.delete(entity);
    }
}




















































