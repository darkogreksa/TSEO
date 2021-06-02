package com.example.tseo.service;

import com.example.tseo.model.PredavanjePredmeta;
import com.example.tseo.repository.PredavanjePredmetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PredavanjePredmetaService {

    @Autowired
    private PredavanjePredmetaRepository predavanjeRepo;

    public List<PredavanjePredmeta> findAll() {
        return predavanjeRepo.findAll();
    }

    public PredavanjePredmeta getOne(Long id) {
        return predavanjeRepo.getOne(id);
    }

    public PredavanjePredmeta create(PredavanjePredmeta predavanje) {
        return predavanjeRepo.save(predavanje);
    }

    public PredavanjePredmeta update(PredavanjePredmeta predavanje) {
        return predavanjeRepo.save(predavanje);
    }

    public void deleteLogically(PredavanjePredmeta predavanje) {
        predavanje.setObrisan(true);
        //logika za kaskadno brisanje ovde...
        predavanjeRepo.save(predavanje);
    }

    public void deleteById(Long id) {
        predavanjeRepo.deleteById(id);
    }

    public void delete(PredavanjePredmeta predavanje) {
        predavanjeRepo.delete(predavanje);
    }


}
