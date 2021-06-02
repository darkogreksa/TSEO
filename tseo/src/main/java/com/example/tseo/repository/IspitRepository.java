package com.example.tseo.repository;

import com.example.tseo.model.Ispit;
import com.example.tseo.model.IspitniRok;
import com.example.tseo.model.Predmet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface    IspitRepository extends JpaRepository<Ispit, Long> {
    public List<Ispit> getAllByPredmet(Predmet predmet);
    public List<Ispit> getAllByRokAndPredmet(IspitniRok rok, Predmet predmet);
}
