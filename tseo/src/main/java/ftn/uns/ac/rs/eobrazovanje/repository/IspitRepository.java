package ftn.uns.ac.rs.eobrazovanje.repository;

import ftn.uns.ac.rs.eobrazovanje.dto.IspitZaOcenjivanjeDTO;
import ftn.uns.ac.rs.eobrazovanje.dto.IspitiZaPrijavuDTO;
import ftn.uns.ac.rs.eobrazovanje.model.Ispit;
import ftn.uns.ac.rs.eobrazovanje.model.IspitniRok;
import ftn.uns.ac.rs.eobrazovanje.model.Nastavnik;
import ftn.uns.ac.rs.eobrazovanje.model.Predmet;
import ftn.uns.ac.rs.eobrazovanje.model.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IspitRepository extends JpaRepository<Ispit, Long> {
    public List<Ispit> getAllByPredmet(Predmet predmet);
    public List<Ispit> getAllByRokAndPredmet(IspitniRok rok, Predmet predmet);

    @Query(value = "select isp " +
            "from Ispit isp join isp.predmet predmet " +
            "join predmet.izvedbe izvedbe join izvedbe.predavanja predavanja " +
            "where predavanja.nastavnik = :nastavnik and isp.vrsta = 'Ispit'")
    public List<Ispit> getAllZaNastavnika(@Param("nastavnik") Nastavnik nastavnik);

    @Query(value = "select isp " +
            "from Ispit isp join isp.predmet predmet " +
            "join predmet.izvedbe izvedbe join izvedbe.predavanja predavanja " +
            "where predavanja.nastavnik = :nastavnik and isp.vrsta = 'Kolokvijum'")
    public List<Ispit> getAllKolokvijumiZaNastavnika(@Param("nastavnik") Nastavnik nastavnik);

    @Query(value = "select new ftn.uns.ac.rs.eobrazovanje.dto.IspitZaOcenjivanjeDTO(" +
            "   isp.id, isp.datum, p.id, p.sifraPredmeta, p.naziv, isp.vrsta) " +
            "from Ispit isp join isp.izlasci izl " +
            "join isp.predmet p join p.izvedbe izv join izv.predavanja pred " +
            "where pred.nastavnik = :nastavnik and isp.rok = :rok ")
    public List<IspitZaOcenjivanjeDTO> getAllIspitiForGradingByRokAndNastavnik(
            @Param("rok") IspitniRok r, @Param("nastavnik") Nastavnik n);
}
