package com.example.tseo.repository;

import com.example.tseo.model.Predmet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PredmetRepository extends JpaRepository<Predmet, Long> {

}
