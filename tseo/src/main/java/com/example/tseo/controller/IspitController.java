package com.example.tseo.controller;

import com.example.tseo.dto.IspitDTO;
import com.example.tseo.dto.PredmetDTO;
import com.example.tseo.service.IspitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/ispit")
public class IspitController {

    @Autowired
    IspitService ispitService;

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
}
