package com.example.tseo.controller;

import com.example.tseo.dto.DokumentDTO;
import com.example.tseo.model.DokumentStudent;
import com.example.tseo.service.DokumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/dokument")
@CrossOrigin(origins = "http://localhost:4200")
public class DokumentController {

    @Autowired
    private DokumentService dokumentService;

    @GetMapping(value = "/all")
    public ResponseEntity<List<DokumentDTO>> getAll(){
        List<DokumentStudent> dokumenti = dokumentService.getAll();
        List<DokumentDTO> dokumentDTOS = new ArrayList<>();
        for (DokumentStudent d : dokumenti){
            dokumentDTOS.add(new DokumentDTO(d));
        }

        return new ResponseEntity<List<DokumentDTO>>(dokumentDTOS, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<DokumentDTO> getById(@PathVariable("id") Long id){
        DokumentStudent dokument = dokumentService.getById(id);
        DokumentDTO dokumentDTO = new DokumentDTO(dokument);
        if(dokument == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(dokumentDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<DokumentDTO> addDokument(@RequestBody DokumentDTO dokumentDTO){
        DokumentStudent dokument = new DokumentStudent();
        dokument.setNaziv(dokumentDTO.getNaziv());

        dokument = dokumentService.addDokument(dokument);

        return new ResponseEntity<DokumentDTO>(new DokumentDTO(dokument), HttpStatus.CREATED);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<DokumentDTO> updateDokument(@RequestBody DokumentDTO dokumentDTO, @PathVariable("id") Long id){
        DokumentStudent dokument = dokumentService.getById(id);
        if(dokument == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        dokument.setNaziv(dokumentDTO.getNaziv());
        dokument = dokumentService.addDokument(dokument);
        return new ResponseEntity<DokumentDTO>(new DokumentDTO(dokument), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> deleteDokument(@PathVariable("id") Long id){
        DokumentStudent dokument = dokumentService.getById(id);
        if(dokument == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        dokumentService.deleteDokument(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
