package ftn.uns.ac.rs.eobrazovanje.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.uns.ac.rs.eobrazovanje.model.IzlazakNaIspit;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IzlazakRepository extends JpaRepository<IzlazakNaIspit, Long> {

    List<IzlazakNaIspit> findAllByIspit_Id(Long ispitId);
    
    List<IzlazakNaIspit> findAllDistinctByStudentIdAndPolozioFalse(Long id);
    
    List<IzlazakNaIspit> findAllByStudentIdAndPolozioTrue(Long id);

}
