package ftn.uns.ac.rs.eobrazovanje.repository;

import ftn.uns.ac.rs.eobrazovanje.model.IzvedbaPredmeta;
import ftn.uns.ac.rs.eobrazovanje.model.Nastavnik;
import ftn.uns.ac.rs.eobrazovanje.model.PredavanjePredmeta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PredavanjePredmetaRepository extends JpaRepository<PredavanjePredmeta, Long> {
    public List<PredavanjePredmeta> getAllByNastavnik(Nastavnik nastavnik);
    public List<PredavanjePredmeta> getAllByNastavnik_Id(Long nastavnikId);
    public List<PredavanjePredmeta> getAllByIzvedba(IzvedbaPredmeta izvedba);
    public List<PredavanjePredmeta> getAllByIzvedba_Id(Long izvedbaId);
}
