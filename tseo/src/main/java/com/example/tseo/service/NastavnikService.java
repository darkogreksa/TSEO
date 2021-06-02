package com.example.tseo.service;

import com.example.tseo.model.Nastavnik;
import com.example.tseo.repository.IspitniRokRepository;
import com.example.tseo.repository.NastavnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NastavnikService {

    @Autowired
    private NastavnikRepository nastavnikRepository;

    @Autowired
    private IspitniRokRepository rokRepository;

    public List<Nastavnik> getAll() {
        return nastavnikRepository.findAll();
    }

    public Nastavnik getOne(Long id) {
        return nastavnikRepository.getOne(id);
    }

    public Nastavnik create (Nastavnik n) {
        return nastavnikRepository.save(n);
    }

    public Nastavnik update (Nastavnik n) {
        return nastavnikRepository.save(n);
    }

    public void deleteLogically (Nastavnik n) {
        n.setObrisan(true);
        nastavnikRepository.save(n);
    }

    public void deleteById(Long id) {
        nastavnikRepository.deleteById(id);
    }

    public void delete(Nastavnik n) {
        nastavnikRepository.delete(n);
    }

}
