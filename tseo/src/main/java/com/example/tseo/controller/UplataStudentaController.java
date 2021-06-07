package com.example.tseo.controller;

import com.example.tseo.dto.UplataStudentaDTO;
import com.example.tseo.model.Student;
import com.example.tseo.model.UplataStudenta;
import com.example.tseo.service.StudentService;
import com.example.tseo.service.UplataStudentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/uplata")
public class UplataStudentaController {

    @Autowired
    private UplataStudentaService uplataService;

    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/all")
    public ResponseEntity<List<UplataStudentaDTO>>getAll() {
        List<UplataStudenta> uplate = uplataService.getAll();
        List<UplataStudentaDTO> uplateDTOs = new ArrayList<>();
        for (UplataStudenta u : uplate) {
            uplateDTOs.add(new UplataStudentaDTO(u));
        }

        return new ResponseEntity<List<UplataStudentaDTO>>(uplateDTOs, HttpStatus.OK);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<UplataStudentaDTO> getOne(@PathVariable("id") Long id) {
        UplataStudenta uplata = uplataService.getOne(id);

        if (uplata == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        UplataStudentaDTO uplataDTO = new UplataStudentaDTO(uplata);

        return new ResponseEntity<UplataStudentaDTO>(uplataDTO, HttpStatus.OK);
    }



    @PostMapping(value = "", consumes = "application/json")
    public ResponseEntity<UplataStudentaDTO> create (@RequestBody UplataStudentaDTO uplataDTO) {
        UplataStudenta uplata = new UplataStudenta();

        uplata.setDatum(uplataDTO.getDatum());
        uplata.setIznos(uplataDTO.getIznos());
        uplata.setObrisan(uplataDTO.isObrisan());

        // dodeljivanje studenta uplati
        Student st = studentService.getOne(uplataDTO.getStudentDTO().getId());
        if (st != null) {
            uplata.setStudent(st);
        }

        uplata = uplataService.create(uplata);
        return new ResponseEntity<UplataStudentaDTO>(new UplataStudentaDTO(uplata), HttpStatus.CREATED);
    }


    @PutMapping(value = "/{id}",consumes = "application/json")
    public ResponseEntity<UplataStudentaDTO> update(@PathVariable("id") Long id, @RequestBody UplataStudentaDTO uplataDTO) {
        UplataStudenta uplata = uplataService.getOne(id);
        if (uplata == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if (uplataDTO.isObrisan() == true) {
            uplataService.deleteLogically(uplata);
            return new ResponseEntity<UplataStudentaDTO>(new UplataStudentaDTO(uplata), HttpStatus.OK);
        }

        Student st = studentService.getOne(uplataDTO.getStudentDTO().getId());
        if (st == null) {
            return new ResponseEntity<UplataStudentaDTO>(HttpStatus.CONFLICT);
        }
        uplata.setStudent(st);
        uplata.setIznos(uplataDTO.getIznos());
        uplata.setDatum(uplataDTO.getDatum());

        uplata = uplataService.update(uplata);

        return new ResponseEntity<UplataStudentaDTO>(new UplataStudentaDTO(uplata), HttpStatus.OK);
    }

    @DeleteMapping(value = {"/{id}"})
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        UplataStudenta uplata = uplataService.getOne(id);
        if (uplata == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        uplataService.delete(uplata);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
