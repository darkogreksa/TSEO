package com.example.tseo.service;

import com.example.tseo.model.UplataStudenta;
import com.example.tseo.repository.UplataStudentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UplataStudentaService {

    @Autowired
    private UplataStudentaRepository uplataStudentaRepository;

    public List<UplataStudenta> getAll() {
        return  uplataStudentaRepository.findAll();
    }

    public UplataStudenta getOne(Long id) {
        return uplataStudentaRepository.getOne(id);
    }

    public UplataStudenta create(UplataStudenta u) {
        return uplataStudentaRepository.save(u);
    }

    public UplataStudenta update(UplataStudenta u) {
        return uplataStudentaRepository.save(u);
    }

    public void deleteLogically(UplataStudenta u) {
        u.setObrisan(true);
        uplataStudentaRepository.save(u);
    }

    public void delete(Long id) {
        uplataStudentaRepository.deleteById(id);
    }

    public void delete(UplataStudenta u) {
        uplataStudentaRepository.delete(u);
    }

}
