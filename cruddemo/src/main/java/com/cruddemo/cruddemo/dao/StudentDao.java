package com.cruddemo.cruddemo.dao;

import com.cruddemo.cruddemo.Entity.Student;

import java.util.List;

public interface StudentDao {
    void save (Student theStudent);

    Student findById(Integer id);
    List<Student> findAll();
    List<Student> findByName(String theName);
    void update(Student theStudent);
    void delete(Integer id);
}
