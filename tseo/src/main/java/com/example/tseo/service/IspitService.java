package com.example.tseo.service;

import com.example.tseo.dto.IspitDTO;
import com.example.tseo.model.Ispit;
import com.example.tseo.model.IspitniRok;
import com.example.tseo.model.Predmet;
import com.example.tseo.repository.IspitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IspitService {

    @Autowired
    IspitRepository ispitRepo;

    public List<IspitDTO> getAll() {
        List<IspitDTO> i = ispitRepo.findAll().stream().map(ispit -> new IspitDTO(ispit))
                .collect(Collectors.toList());
        return i;
    }

    public IspitDTO getById(Long id) {
        Ispit ispit = ispitRepo.getOne(id);
        if (ispit == null)
            return null;
        else
            return new IspitDTO(ispit);
    }

    public boolean addIspit(IspitDTO ispitDTO) {
        if(ispitDTO != null) {
            Ispit ispit = new Ispit();
            ispit.setUcionica(ispitDTO.getUcionica());
            ispit.setDatum(ispitDTO.getDatum());
            ispit.setVrsta(ispitDTO.getVrsta());
            ispit.setPredmet(ispitDTO.getPredmet());
            System.out.println(ispitDTO.getIspitniRok());
            ispit.setRok(ispitDTO.getIspitniRok());
            ispitRepo.save(ispit);
            return true;
        }
        else {
            return false;
        }
    }

    public boolean deletePredmet(Long id) {
        Ispit ispit = ispitRepo.getOne(id);
        try {
            ispitRepo.delete(ispit);
            return true;
        }
        catch (Exception e) {
            return false;
        }

    }

    public Page<IspitDTO> getAllPage(Integer page, Integer size) {
        PageRequest pr = PageRequest.of(page, size);
        Page<Ispit> i = ispitRepo.findAll(pr);
        Page<IspitDTO> pDTO = i.map(IspitDTO::new);
        return pDTO;
    }

    public List<Ispit> getAllByRokAndPredmet(IspitniRok rok, Predmet predmet) {
        return ispitRepo.getAllByRokAndPredmet(rok, predmet);
    }
}
