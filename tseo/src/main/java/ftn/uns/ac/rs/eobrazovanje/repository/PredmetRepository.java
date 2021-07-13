package ftn.uns.ac.rs.eobrazovanje.repository;

import ftn.uns.ac.rs.eobrazovanje.model.Nastavnik;
import ftn.uns.ac.rs.eobrazovanje.model.Predmet;
import ftn.uns.ac.rs.eobrazovanje.model.IzvedbaPredmeta;
import ftn.uns.ac.rs.eobrazovanje.model.PredavanjePredmeta;
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
