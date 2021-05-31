package com.example.tseo.service;

import com.example.tseo.model.IzvedbaPredmeta;
import com.example.tseo.model.Predmet;
import com.example.tseo.repository.IzvedbaPredmetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class IzvedbaPredmetaService {
    @Autowired
    private IzvedbaPredmetaRepository izvedbaRepo;

    public List<IzvedbaPredmeta> findAll() {
        return izvedbaRepo.findAll();
    }

    public IzvedbaPredmeta getOne(Long id) {
        return izvedbaRepo.getOne(id);
    }

    public IzvedbaPredmeta create(IzvedbaPredmeta izvedba) {
        return izvedbaRepo.save(izvedba);
    }

    public IzvedbaPredmeta update(IzvedbaPredmeta izvedba) {
        return izvedbaRepo.save(izvedba);
    }

//    public void deleteLogically(IzvedbaPredmeta izvedba) {
//        izvedba.setObrisan(true);
//        izvedbaRepo.save(izvedba);
//    }

    public void delete(IzvedbaPredmeta izvedba) {
        izvedbaRepo.delete(izvedba);
    }

    public void deleteById(Long id) {
        izvedbaRepo.deleteById(id);
    }

//    public List<IzvedbaPredmeta> getAllByPocetakAfterAndKrajBefore(Date startDate, Date endDate) {
//        return izvedbaRepo.getAllByPocetakAfterAndKrajBefore(startDate, endDate);
//    }
//    public List<IzvedbaPredmeta> getAllByPredmet(Predmet predmet){
//        return izvedbaRepo.getAllByPredmet(predmet);
//    }
//    public List<IzvedbaPredmeta> getAllByPredmet_Id(Long predmetId){
//        return izvedbaRepo.getAllByPredmet_Id(predmetId);
//    }

}
