package ftn.uns.ac.rs.eobrazovanje.controller;

import ftn.uns.ac.rs.eobrazovanje.dto.KorisnikDTO;
import ftn.uns.ac.rs.eobrazovanje.dto.NastavnikDTO;
import ftn.uns.ac.rs.eobrazovanje.model.Korisnik;
import ftn.uns.ac.rs.eobrazovanje.model.Nastavnik;
import ftn.uns.ac.rs.eobrazovanje.servis.KorisnikService;
import ftn.uns.ac.rs.eobrazovanje.servis.NastavnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/nastavnik")
public class NastavnikController {

    @Autowired
    private NastavnikService nastavnikService;
    
    @Autowired
    private KorisnikService korisnikService;

//    @Autowired
//    private KorisnickiNalogService korisnickiNalogService;

    @GetMapping(value = "/all")
    public ResponseEntity<List<NastavnikDTO>> getAll(){
        List<NastavnikDTO> nastavnikDTOS = new ArrayList<>();
        List<Nastavnik> nastavniks = nastavnikService.getAll();
        for (Nastavnik n : nastavniks) {
            nastavnikDTOS.add(new NastavnikDTO(n));
        }

        return new ResponseEntity<List<NastavnikDTO>>(nastavnikDTOS, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<NastavnikDTO> getOne(@PathVariable("id") Long id) {
        Nastavnik nastavnik = nastavnikService.getOne(id);
        Korisnik korisnik = new Korisnik();
        KorisnikDTO kdto = new KorisnikDTO();
        if(nastavnik.getKorisnik()!=null) {
        	korisnik = korisnikService.getOne(nastavnik.getKorisnik().getId());
        	kdto = new KorisnikDTO(korisnik);
        }

//        if (nastavnik == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }

        NastavnikDTO nastavnikDTO = new NastavnikDTO(nastavnik, kdto);

        return new ResponseEntity<NastavnikDTO>(nastavnikDTO, HttpStatus.OK);
    }

    @PostMapping(value = {"", "/"}, consumes = "application/json")
    public ResponseEntity<NastavnikDTO> create(@RequestBody NastavnikDTO nastavnikDTO) {
        Nastavnik nastavnik = new Nastavnik();

        nastavnik.setIme(nastavnikDTO.getIme());
        nastavnik.setPrezime(nastavnikDTO.getPrezime());
        nastavnik.setJmbg(nastavnikDTO.getJmbg());
        nastavnik.setMestoStanovanja(nastavnikDTO.getMestoStanovanja());
        // dodavanje korisnickog naloga nastavniku
//        KorisnickiNalog kn = korisnickiNalogService.getOne(nastavnikDTO.nalog.getId());
//        if (kn != null) {
//            nastavnik.setKorisnickiNalog(kn);
//        }

        nastavnik = nastavnikService.create(nastavnik);
        return new ResponseEntity<NastavnikDTO>(new NastavnikDTO(nastavnik), HttpStatus.CREATED);
    }

    @PutMapping(consumes = "application/json")
    public ResponseEntity<NastavnikDTO> update(@RequestBody NastavnikDTO n) {
        Nastavnik nastavnik = nastavnikService.getOne(n.getId());
        if (nastavnik == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if (n.isObrisan() == true) {
            nastavnikService.deleteLogically(nastavnik);
            return new ResponseEntity<NastavnikDTO>(new NastavnikDTO(nastavnik), HttpStatus.OK);
        }

        nastavnik.setIme(n.getIme());
        nastavnik.setPrezime(n.getPrezime());
        nastavnik.setJmbg(n.getJmbg());
        nastavnik.setMestoStanovanja(n.getMestoStanovanja());

        // izmena korisnickog naloga ovde...

        nastavnik = nastavnikService.update(nastavnik);

        return new ResponseEntity<NastavnikDTO>(new NastavnikDTO(nastavnik), HttpStatus.OK);
    }

    @DeleteMapping(value = {"/{id}"})
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        Nastavnik nastavnik = nastavnikService.getOne(id);
        if (nastavnik == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        nastavnikService.delete(nastavnik);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
