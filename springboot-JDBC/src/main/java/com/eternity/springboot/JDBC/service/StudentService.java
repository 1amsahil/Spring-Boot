package com.eternity.springboot.JDBC.service;

import com.eternity.springboot.JDBC.model.Student;
import com.eternity.springboot.JDBC.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentRepo repo;

    public StudentRepo getRepo() {
        return repo;
    }

    @Autowired
    public void setRepo(StudentRepo repo) {
        this.repo = repo;
    }

    public void addStudent(Student st)
    {
        repo.save(st);
    }

    public List<Student> getStudents()
    {
        return repo.findAll();
    }
}
