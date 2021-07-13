package ftn.uns.ac.rs.eobrazovanje.repository;

import ftn.uns.ac.rs.eobrazovanje.model.IzvedbaPredmeta;
import ftn.uns.ac.rs.eobrazovanje.model.PohadjanjePredmeta;
import ftn.uns.ac.rs.eobrazovanje.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PohadjanjePredmetaRepository extends JpaRepository<PohadjanjePredmeta, Long> {
    public List<PohadjanjePredmeta> getAllByIzvedba(IzvedbaPredmeta izvedba);
    public List<PohadjanjePredmeta> getAllByIzvedba_Id(Long izvedbaId);
    public List<PohadjanjePredmeta> getAllByStudent(Student student);
    public List<PohadjanjePredmeta> getAllByStudent_Id(Long studentId);
}
