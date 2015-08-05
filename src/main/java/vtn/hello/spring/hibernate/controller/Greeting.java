package vtn.hello.spring.hibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vtn.hello.spring.hibernate.controller.service.PersonService;
import vtn.hello.spring.hibernate.model.Person;

@RestController
public class Greeting {

    @Autowired
    private PersonService service;

    @RequestMapping("/greeting")
    public Object greeting() {
        return "Hello! Welcome to Spring and Hibernate!";
    }

    @RequestMapping("/all")
    public Object getAll() {
        return service.getAllPerson();
    }

    @RequestMapping("/add")
    public Object getAdd() {
        Person person = new Person();
        person.setName(System.currentTimeMillis() + "");
        person.setCountry(System.currentTimeMillis() + "");
        service.persist(person);
        return service.getAllPerson();
    }
}
