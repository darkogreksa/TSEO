package com.example.tseo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class CrudService <T, ER extends JpaRepository<T, ID>, ID>{

    @Autowired
    ER er;

    public List<T> getAll(){
        return er.findAll();
    }

    public T getOne(ID id) {
        return er.findById(id).orElse(null);
    }

    public T save(T t) {
        return er.save(t);
    }

    public void deleteById(ID id) {
        er.deleteById(id);
    }

    public void delete(T t) {
        er.delete(t);
    }

}
