package com.example.tseo.controller;

import com.example.tseo.dto.IzlazakDTO;
import com.example.tseo.model.IzlazakNaIspit;
import com.example.tseo.service.IzlazakNaIspitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/izlazak")
public class IzlazakNaIspitController {

    @Autowired
    IzlazakNaIspitService izlazakNaIspitService;

    @GetMapping(value = "/all")
    public ResponseEntity<List<IzlazakDTO>> getAll(){
        List<IzlazakDTO> iDTO = new ArrayList<>();
        List<IzlazakNaIspit> izlasci = izlazakNaIspitService.getAll();
        for(IzlazakNaIspit i : izlasci) {
            iDTO.add(new IzlazakDTO(i));
        }
        return new ResponseEntity<List<IzlazakDTO>>(iDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<IzlazakDTO> getOne(@PathVariable("id") Long id){
        IzlazakNaIspit i = izlazakNaIspitService.getOne(id);
        if(i == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<IzlazakDTO>(new IzlazakDTO(i), HttpStatus.OK);
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        IzlazakNaIspit i = izlazakNaIspitService.getOne(id);
        if(i == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            izlazakNaIspitService.deleteById(id);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
    }
}
