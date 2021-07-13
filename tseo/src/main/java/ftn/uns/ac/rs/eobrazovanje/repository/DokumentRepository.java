package ftn.uns.ac.rs.eobrazovanje.repository;

import ftn.uns.ac.rs.eobrazovanje.model.DokumentStudent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DokumentRepository extends JpaRepository<DokumentStudent, Long> {

    List<DokumentStudent> findAllByStudentId(Long id);
    DokumentStudent findAllByNaziv(String naziv);
}
