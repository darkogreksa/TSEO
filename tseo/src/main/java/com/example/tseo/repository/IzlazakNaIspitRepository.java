package com.example.tseo.repository;

import com.example.tseo.model.IzlazakNaIspit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IzlazakNaIspitRepository extends JpaRepository<IzlazakNaIspit, Long> {
    List<IzlazakNaIspit> findAllByIspit_Id(Long ispitId);
    List<IzlazakNaIspit> findAllDistinctByStudentIdAndPolozioFalse(Long id);
    List<IzlazakNaIspit> findAllByStudentIdAndPolozioTrue(Long id);
}
