package com.example.tseo.repository;

import com.example.tseo.model.Nastavnik;
import com.example.tseo.model.Predmet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PredmetRepository extends JpaRepository<Predmet, Long> {

    @Query(value = "select p from Predmet p join p.izvedbe izv " +
            "join izv.predavanja pred " +
            "where pred.nastavnik = :nastavnik ")
    public List<Predmet> getAllThatNastavnikIzvodi(@Param("nastavnik") Nastavnik nastavnik);
}
