package com.example.tseo.controller;

import com.example.tseo.dto.IspitDTO;
import com.example.tseo.dto.IspitZaNastavnikaDTO;
import com.example.tseo.dto.IspitZaOcenjivanjeDTO;
import com.example.tseo.dto.PredmetDTO;
import com.example.tseo.model.Ispit;
import com.example.tseo.model.IspitniRok;
import com.example.tseo.model.Nastavnik;
import com.example.tseo.repository.IspitRepository;
import com.example.tseo.repository.IspitniRokRepository;
import com.example.tseo.repository.PredmetRepository;
import com.example.tseo.service.IspitService;
import com.example.tseo.service.NastavnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/ispit")
public class IspitController {

    @Autowired
    IspitRepository ispitRepository;

    @Autowired
    PredmetRepository predmetRepository;

    @Autowired
    NastavnikService nastavnikService;

    @Autowired
    IspitService ispitService;

    @Autowired
    IspitniRokRepository ispitniRokRepository;

    @GetMapping(value = "/all")
    public ResponseEntity<List<IspitDTO>> getAll(){
        List<IspitDTO> ispiti = ispitService.getAll();
        return new ResponseEntity<List<IspitDTO>>(ispiti, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<IspitDTO> getById(@PathVariable("id") Long id){
        IspitDTO ispit = ispitService.getById(id);
        if(ispit == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<IspitDTO>(ispit, HttpStatus.OK);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<PredmetDTO> addPredmet(@RequestBody IspitDTO ispitDTO){
        System.out.println(ispitDTO.getIspitniRok());
        if(ispitService.addIspit(ispitDTO)) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<HttpStatus> update(@RequestBody IspitDTO ispitDTO) {
        if(ispitService.addIspit(ispitDTO)) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        if(ispitService.deletePredmet(id)) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/nastavnik/{nastavnikId}")
    public ResponseEntity<List<IspitZaNastavnikaDTO>> getAllByNastavnik(@PathVariable("nastavnikId") Long id) {
        Nastavnik nastavnik = nastavnikService.getOne(id);

        if (nastavnik == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        List<Ispit> ispiti = ispitRepository.getAllZaNastavnika(nastavnik);
        List<IspitZaNastavnikaDTO> ispitDTOs = new ArrayList<IspitZaNastavnikaDTO>();
        for (Ispit isp : ispiti) {
            IspitZaNastavnikaDTO dto = new IspitZaNastavnikaDTO(isp);
            ispitDTOs.add(dto);
        }

        return new ResponseEntity<List<IspitZaNastavnikaDTO>>(ispitDTOs, HttpStatus.OK);

    }
    @GetMapping(value = "/kolokvijum/nastavnik/{nastavnikId}")
    public ResponseEntity<List<IspitZaNastavnikaDTO>> getAllKolokvijumiByNastavnik(@PathVariable("nastavnikId") Long id) {
        Nastavnik nastavnik = nastavnikService.getOne(id);

        if (nastavnik == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        List<Ispit> ispiti = ispitRepository.getAllKolokvijumiZaNastavnika(nastavnik);
        List<IspitZaNastavnikaDTO> ispitDTOs = new ArrayList<IspitZaNastavnikaDTO>();
        for (Ispit isp : ispiti) {
            IspitZaNastavnikaDTO dto = new IspitZaNastavnikaDTO(isp);
            ispitDTOs.add(dto);
        }
        return new ResponseEntity<List<IspitZaNastavnikaDTO>>(ispitDTOs, HttpStatus.OK);
    }


    @GetMapping(value = "/ocenjivanje/nastavnik/{nastavnikId}")
    public ResponseEntity<List<IspitZaNastavnikaDTO>> getAllIspitiForGradingByNastavnik(@PathVariable("nastavnikId") Long nastavnikId){
        Nastavnik nastavnik = nastavnikService.getOne(nastavnikId);
        if (nastavnik == null)
            return new ResponseEntity<List<IspitZaNastavnikaDTO>>(HttpStatus.BAD_REQUEST);

        List<IspitZaNastavnikaDTO> ispiti = nastavnikService.getIspitiZaOcenjivanjeSviRokovi(nastavnik);

        return new ResponseEntity<List<IspitZaNastavnikaDTO>>(ispiti, HttpStatus.OK);
    }

    //dobavlja sve ispite za koje je potrebno oceniti radove (iz predmeta koje dati nastavnik izvodi)
    @GetMapping(value = "/ocenjivanje/nastavnik/{nastavnikId}/rok/{rokId}")
    public ResponseEntity<List<IspitZaOcenjivanjeDTO>> getAllIspitiForGradingByRokAndNastavnik(@PathVariable("nastavnikId") Long nastavnikId, @PathVariable("rokId") Long rokId){
        Nastavnik nastavnik = nastavnikService.getOne(nastavnikId);
        if (nastavnik == null)
            return new ResponseEntity<List<IspitZaOcenjivanjeDTO>>(HttpStatus.BAD_REQUEST);


        IspitniRok rok = ispitniRokRepository.getOne(rokId);
        if (rok == null)
            return new ResponseEntity<List<IspitZaOcenjivanjeDTO>>(HttpStatus.BAD_REQUEST);


        List<IspitZaOcenjivanjeDTO> ispiti = nastavnikService.getIspitiZaOcenjivanje(nastavnik, rok);

        return new ResponseEntity<List<IspitZaOcenjivanjeDTO>>(ispiti, HttpStatus.OK);
    }
}
