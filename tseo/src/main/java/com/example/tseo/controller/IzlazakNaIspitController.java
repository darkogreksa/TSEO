package com.example.tseo.controller;

import com.example.tseo.dto.IspitiZaPrijavuDTO;
import com.example.tseo.dto.IzlazakDTO;
import com.example.tseo.dto.IzlazakPolozioDTO;
import com.example.tseo.model.*;
import com.example.tseo.service.*;
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

    @Autowired
    IspitService ispitService;

    @Autowired
    StudentService studentService;

    @Autowired
    IspitniRokService irService;

    @Autowired
    KorisnikService korisnikService;

    @Autowired
    PohadjanjePredmetaService pohadjanjeService;

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

    @GetMapping(value = "/student/{id}")
    public ResponseEntity<List<IzlazakPolozioDTO>> studentPolozio(@PathVariable("id") Long id){
        List<IzlazakNaIspit> polozio = izlazakNaIspitService.getAllByStudentNijePolozio(id);
        if(polozio == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        List<IzlazakPolozioDTO> iDTO = new ArrayList<>();
        for(IzlazakNaIspit i : polozio) {
            iDTO.add(new IzlazakPolozioDTO(i));
        }
        return new ResponseEntity<List<IzlazakPolozioDTO>>(iDTO, HttpStatus.OK);
    }


    @GetMapping(value = "/student/{username}/nepolozeno/{rok}")
    public ResponseEntity<List<IspitiZaPrijavuDTO>> getAllNepolozeniByStudent(@PathVariable("username") String username, @PathVariable("rok") Long rok){
        Korisnik korisnik = korisnikService.findByUsername(username);
        Student student = studentService.getOne(korisnik.getStudent().getId());
        if (student == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            IspitniRok ir = irService.getOne(rok);
            List<Ispit> ispiti = new ArrayList<>();
            List<Predmet> predmetiStudenta = new ArrayList<>();
            List<Predmet> polozeniPredmetiStudenta = new ArrayList<>();
            List<IspitiZaPrijavuDTO> nijePolozio = new ArrayList<>();
            List<IzlazakNaIspit> polozio = izlazakNaIspitService.getAllByStudentPolozio(student.getId());
            List<IspitiZaPrijavuDTO> zaPrijavu = new ArrayList<>();
//			zaPrijavu = ispitService.getAllIspitiZaPrijavu(student, ir);
            List<PohadjanjePredmeta> studentPohadja = pohadjanjeService.getAllByStudent(student);

            for(PohadjanjePredmeta i : studentPohadja) {
                predmetiStudenta.add(i.getIzvedba().getPredmet());
            }

            for(IzlazakNaIspit ii : polozio) {
                polozeniPredmetiStudenta.add(ii.getIspit().getPredmet());
            }

            studentPohadja.removeAll(polozeniPredmetiStudenta);

            for(Predmet pr : predmetiStudenta) {
                ispiti = ispitService.getAllByRokAndPredmet(ir, pr);
//				IspitiZaPrijavuDTO ip = new IspitiZaPrijavuDTO(pr, new Ispit());
//				zaPrijavu.add(ip);
            }

            for(Ispit i : ispiti) {
                zaPrijavu.add(new IspitiZaPrijavuDTO(i));
            }

            return new ResponseEntity<List<IspitiZaPrijavuDTO>>(zaPrijavu, HttpStatus.OK);
        }
    }
}
