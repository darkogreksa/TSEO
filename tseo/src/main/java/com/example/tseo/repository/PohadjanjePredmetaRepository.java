package com.example.tseo.repository;

import com.example.tseo.model.IzvedbaPredmeta;
import com.example.tseo.model.PohadjanjePredmeta;
import com.example.tseo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PohadjanjePredmetaRepository extends JpaRepository<PohadjanjePredmeta, Long> {
}
