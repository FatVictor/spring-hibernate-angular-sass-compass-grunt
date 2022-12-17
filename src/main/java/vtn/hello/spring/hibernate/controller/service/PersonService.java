package vtn.hello.spring.hibernate.controller.service;

import java.util.List;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import vtn.hello.spring.hibernate.model.Person;

@Transactional
@Component
public class PersonService {

    @Autowired
    private SessionFactory sessionFactory;

    public void persist(Person person) {
        getCurrentSession().persist(person);
    }

    public void update(Person person) {
        getCurrentSession().update(person);
    }

    public List<Person> getAllPerson() {
        CriteriaBuilder cb = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Person> cq = cb.createQuery(Person.class);
        Root<Person> rootEntry = cq.from(Person.class);
        CriteriaQuery<Person> all = cq.select(rootEntry);
        return getCurrentSession().createQuery(all).list();
    }

    public Person getPersonById(int id) {
        return getCurrentSession().load(Person.class, id);
    }

    public void removePerson(int id) {
        Session session = getCurrentSession();
        Person person = session.load(Person.class, id);
        session.delete(person);
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
