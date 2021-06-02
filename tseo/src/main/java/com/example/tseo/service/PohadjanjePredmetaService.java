package com.example.tseo.service;

import com.example.tseo.model.PohadjanjePredmeta;
import com.example.tseo.repository.PohadjanjePredmetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PohadjanjePredmetaService {
    @Autowired
    private PohadjanjePredmetaRepository pohadjanjeRepo;

    public List<PohadjanjePredmeta> findAll() {
        return pohadjanjeRepo.findAll();
    }

    public PohadjanjePredmeta getOne(Long id) {
        return  pohadjanjeRepo.getOne(id);
    }

    public PohadjanjePredmeta create(PohadjanjePredmeta pohadjanje) {
        return pohadjanjeRepo.save(pohadjanje);
    }

    public PohadjanjePredmeta update(PohadjanjePredmeta pohadjanje) {
        return  pohadjanjeRepo.save(pohadjanje);
    }

    public void deleteLogically(PohadjanjePredmeta pohadjanje) {
        pohadjanje.setObrisan(true);
        pohadjanjeRepo.save(pohadjanje);
    }

    public void deleteById(Long id) {
        pohadjanjeRepo.deleteById(id);
    }

}
