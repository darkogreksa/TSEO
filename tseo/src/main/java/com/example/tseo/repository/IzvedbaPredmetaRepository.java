package com.example.tseo.repository;

import com.example.tseo.model.IzvedbaPredmeta;
import com.example.tseo.model.Predmet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface IzvedbaPredmetaRepository extends JpaRepository<IzvedbaPredmeta, Long> {
    public List<IzvedbaPredmeta> getAllByPocetakAfterAndKrajBefore(Date startDate, Date endDate);
    public List<IzvedbaPredmeta> getAllByPredmet(Predmet predmet);
    public List<IzvedbaPredmeta> getAllByPredmet_Id(Long predmetId);
}
