package com.example.cruddemo.dao;

import java.util.List;

import com.example.cruddemo.Entity.Student;

public interface StudentDAO {

    void save(Student theStudent);

    Student findById(Integer id);

    List<Student> findAll();

    //List<Student> findByLastName(String   theLastName);

    List<Student> findByLastName(String string);

    void update(Student theStudent);


    public void  delete(Integer id);


    int deleteAll();
    


}
