package com.example.tseo.service;

import com.example.tseo.model.IzlazakNaIspit;
import com.example.tseo.repository.IzlazakNaIspitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IzlazakNaIspitService extends CrudService<IzlazakNaIspit, IzlazakNaIspitRepository, Long> {

    @Autowired
    IzlazakNaIspitRepository izlazakNaIspitRepository;

    public List<IzlazakNaIspit> getAllByIspitId(Long id){
        return izlazakNaIspitRepository.findAllByIspit_Id(id);
    }

    public List<IzlazakNaIspit> getAllByStudentPolozio(Long id){
        return izlazakNaIspitRepository.findAllByStudentIdAndPolozioTrue(id);
    }

    public List<IzlazakNaIspit> getAllByStudentNijePolozio(Long id){
        return izlazakNaIspitRepository.findAllDistinctByStudentIdAndPolozioFalse(id);
    }

}
