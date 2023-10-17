package com.example.cruddemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.cruddemo.Entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class StudentDaoImpl implements StudentDAO {
    // define field for entity manager

    private EntityManager entityManager;
    private Query theQuery;

    // inject entity manager using constructor injection
    @Autowired // autowired is optiomal for making it easier with the 1 constructor
    public StudentDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    // implements save method

    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);

    }

    @Override
    public Student findById(Integer id) {
        // TODO Auto-generated method stub
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        // create query
        // segregate - order by lastName asc (from a to z 1 to endless) desc its a
        // reversion of that FROM Student order by lastName asc
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student ", Student.class);
        // TODO Auto-generated method stub
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName) {
        // TODO Auto-generated method stub

        // create query

        TypedQuery<Student> theTypedQuery = entityManager.createQuery("From Student WHERE lastName =:theData ",
                Student.class);
        // set query parameters
        theTypedQuery.setParameter("theData", theLastName);
        // return query results
        return theTypedQuery.getResultList();

    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        // retrive the student
        Student theStudent = entityManager.find(Student.class, id);
        // delete the student
        entityManager.remove(theStudent);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numRowsDeleted = entityManager.createQuery("DELETE FROM Student ").executeUpdate();
        return numRowsDeleted;
    }

}
