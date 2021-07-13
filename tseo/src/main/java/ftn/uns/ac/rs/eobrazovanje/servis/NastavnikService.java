package ftn.uns.ac.rs.eobrazovanje.servis;

import ftn.uns.ac.rs.eobrazovanje.dto.IspitZaNastavnikaDTO;
import ftn.uns.ac.rs.eobrazovanje.dto.IspitZaOcenjivanjeDTO;
import ftn.uns.ac.rs.eobrazovanje.model.*;
import ftn.uns.ac.rs.eobrazovanje.repository.IspitniRokRepository;
import ftn.uns.ac.rs.eobrazovanje.repository.NastavnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NastavnikService {

    @Autowired
    private NastavnikRepository nastavnikRepository;

    @Autowired
    private IspitniRokRepository rokRepository;

    public List<Nastavnik> getAll() {
        return nastavnikRepository.findAll();
    }

    public Nastavnik getOne(Long id) {
        return nastavnikRepository.getOne(id);
    }

    public Nastavnik create (Nastavnik n) {
        return nastavnikRepository.save(n);
    }

    public Nastavnik update (Nastavnik n) {
        return nastavnikRepository.save(n);
    }

    public void deleteLogically (Nastavnik n) {
        n.setObrisan(true);
        nastavnikRepository.save(n);
    }

    public void deleteById(Long id) {
        nastavnikRepository.deleteById(id);
    }

    public void delete(Nastavnik n) {
        nastavnikRepository.delete(n);
    }


    public List<IspitZaOcenjivanjeDTO> getIspitiZaOcenjivanje(Nastavnik nastavnik, IspitniRok rok) {
        //dobavlja predmete koje nastavnik izvodi,
        //dodati proveru da li se datum izvedbe poklapa sa datumom ispita ili roka??
        List<Predmet> predmeti = new ArrayList<>();
        List<IzvedbaPredmeta> izvedbe = new ArrayList<>();
        List<PredavanjePredmeta> predavanja = nastavnik.getPredaje();
        for (PredavanjePredmeta p : predavanja) {
            IzvedbaPredmeta izvedba = p.getIzvedba();
            izvedbe.add(izvedba);
            predmeti.add(izvedba.getPredmet());
        }

        //trazi ispite za predmete koje nastavnik predaje
        List<IspitZaOcenjivanjeDTO> ispitiSaPridruzenimPredmetKolonama = new ArrayList<IspitZaOcenjivanjeDTO>();
        for (Predmet p : predmeti) {
            List<Ispit> ispitiZaPredmet = new ArrayList<Ispit>();
            for (Ispit isp : p.getIspiti()) {
                //filtriranje po unetom roku
                if (isp.getRok() == rok) {

                    // ako nekom nije uneta ocena, tj. "polozio" nije niti true niti false, već null
                    // -> dodaj taj ispit u listu
                    boolean imaNeocenjenih = false;
                    for (IzlazakNaIspit izl : isp.getIzlasci()) {
                        if (izl.getPolozio() == null) {
                            imaNeocenjenih = true;
                            break;
                        }
                    }
                    if (imaNeocenjenih) {
                        ispitiZaPredmet.add(isp);

                        // izdvojiti u neku mapper klasu
                        IspitZaOcenjivanjeDTO ispDTO = new IspitZaOcenjivanjeDTO();
                        ispDTO.setIdIspit(isp.getId());
                        ispDTO.setIdPredmet(p.getId());
                        ispDTO.setDatum(isp.getDatum());
                        ispDTO.setSifra(p.getSifraPredmeta());
                        ispDTO.setNaziv(p.getNaziv());
                        ispDTO.setVrsta(isp.getVrsta());

                        ispitiSaPridruzenimPredmetKolonama.add(ispDTO);
                    }
                }
            }
        }
        return ispitiSaPridruzenimPredmetKolonama;
    }
    public List<IspitZaNastavnikaDTO> getIspitiZaOcenjivanjeSviRokovi(Nastavnik nastavnik) {
        //dobavlja predmete koje nastavnik izvodi,
        //dodati proveru da li se datum izvedbe poklapa sa datumom ispita ili roka??
        List<Predmet> predmeti = new ArrayList<>();
        List<IzvedbaPredmeta> izvedbe = new ArrayList<>();
        List<PredavanjePredmeta> predavanja = nastavnik.getPredaje();
        for (PredavanjePredmeta p : predavanja) {
            IzvedbaPredmeta izvedba = p.getIzvedba();
            izvedbe.add(izvedba);
            predmeti.add(izvedba.getPredmet());
        }

        //trazi ispite za predmete koje nastavnik predaje
        List<IspitZaNastavnikaDTO> ispitiSaPridruzenimPredmetKolonama = new ArrayList<IspitZaNastavnikaDTO>();
        for (Predmet p : predmeti) {
            List<Ispit> ispitiZaPredmet = new ArrayList<Ispit>();
            for (Ispit isp : p.getIspiti()) {
                //filtriranje po unetom roku

                    // ako nekom nije uneta ocena, tj. "polozio" nije niti true niti false, već null
                    // -> dodaj taj ispit u listu
                    boolean imaNeocenjenih = false;
                    for (IzlazakNaIspit izl : isp.getIzlasci()) {
                        if (izl.getPolozio() == null) {
                            imaNeocenjenih = true;
                            break;
                        }
                    }
                    if (imaNeocenjenih) {
                        ispitiZaPredmet.add(isp);

                        // izdvojiti u neku mapper klasu
                        IspitZaNastavnikaDTO ispDTO = new IspitZaNastavnikaDTO(isp);


                        ispitiSaPridruzenimPredmetKolonama.add(ispDTO);
                    }

            }
        }
        return ispitiSaPridruzenimPredmetKolonama;
    }

}
