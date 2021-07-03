package com.example.tseo.repository;

import com.example.tseo.dto.IspitZaOcenjivanjeDTO;
import com.example.tseo.model.Ispit;
import com.example.tseo.model.IspitniRok;
import com.example.tseo.model.Nastavnik;
import com.example.tseo.model.Predmet;
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

    // poboljsati da ne prikazuje ispite u cijim izlascima ne postoji nijedan red sa polozen = null
    // tj ne prikazivati one ispite za koje su već upisane sve ocene...
    @Query(value = "select new ftn.uns.ac.rs.eobrazovanje.dto.IspitZaOcenjivanjeDTO(" +
            "   isp.id, isp.datum, p.id, p.sifraPredmeta, p.naziv, isp.vrsta) " +
            "from Ispit isp join isp.izlasci izl " +
            "join isp.predmet p join p.izvedbe izv join izv.predavanja pred " +
            "where pred.nastavnik = :nastavnik and isp.rok = :rok ")
    public List<IspitZaOcenjivanjeDTO> getAllIspitiForGradingByRokAndNastavnik(
            @Param("rok") IspitniRok r, @Param("nastavnik") Nastavnik n);
}
