package com.example.tseo.controller;

import com.example.tseo.dto.IspitniRokDTO;
import com.example.tseo.model.IspitniRok;
import com.example.tseo.service.IspitniRokService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/ispitni_rok")
public class IspitniRokController {

    @Autowired
    IspitniRokService ispitniRokService;

    @GetMapping
    public ResponseEntity<List<IspitniRokDTO>> getAll(){
        List<IspitniRokDTO> ispitniRokDTOS = new ArrayList<>();
        List<IspitniRok> ispitniRokovi = ispitniRokService.getAll();
        for(IspitniRok i : ispitniRokovi) {
            ispitniRokDTOS.add(new IspitniRokDTO(i));
        }
        return new ResponseEntity<List<IspitniRokDTO>>(ispitniRokDTOS, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<IspitniRokDTO> getOne(@PathVariable("id") Long id){
        IspitniRok ispitniRok = ispitniRokService.getOne(id);
        if(ispitniRok == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<IspitniRokDTO>(new IspitniRokDTO(ispitniRok), HttpStatus.OK);
        }
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<IspitniRokDTO> create(@RequestBody IspitniRokDTO ispitniRokDTO){
        IspitniRok ispitniRok = new IspitniRok();
        ispitniRok.setNaziv(ispitniRokDTO.getNaziv());
        ispitniRok.setDatumPocetka(ispitniRokDTO.getDatumPocetka());
        ispitniRok.setDatumZavrsetka(ispitniRokDTO.getDatumZavrsetka());
        ispitniRok = ispitniRokService.save(ispitniRok);
        return new ResponseEntity<IspitniRokDTO>(new IspitniRokDTO(ispitniRok), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}", consumes = "application/json")
    public ResponseEntity<IspitniRokDTO> update(@PathVariable("id") Long id, @RequestBody IspitniRokDTO ispitniRokDTO){
        IspitniRok ispitniRok = ispitniRokService.getOne(id);
        if (ispitniRok == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            ispitniRok.setNaziv(ispitniRokDTO.getNaziv());
            ispitniRok.setDatumPocetka(ispitniRokDTO.getDatumPocetka());
            ispitniRok.setDatumZavrsetka(ispitniRokDTO.getDatumZavrsetka());
            ispitniRok = ispitniRokService.save(ispitniRok);
            return new ResponseEntity<IspitniRokDTO>(new IspitniRokDTO(ispitniRok), HttpStatus.OK);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        IspitniRok ispitniRok = ispitniRokService.getOne(id);
        if (ispitniRok == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            ispitniRokService.deleteById(id);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
    }


}
