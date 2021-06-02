package com.example.tseo.service;

import com.example.tseo.model.Student;
import com.example.tseo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    public Student getOne(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student create(Student s){
        return studentRepository.save(s);
    }

    public void delete(Long id){
        studentRepository.deleteById(id);
    }

}

