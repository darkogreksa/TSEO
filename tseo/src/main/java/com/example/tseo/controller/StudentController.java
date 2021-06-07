package com.example.tseo.controller;

import com.example.tseo.dto.KorisnikDTO;
import com.example.tseo.dto.StudentDTO;
import com.example.tseo.model.Korisnik;
import com.example.tseo.model.Student;
import com.example.tseo.service.KorisnikService;
import com.example.tseo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/student", produces = "application/json")
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {

    @Autowired
    StudentService studentService;
    
    @Autowired
    KorisnikService korisnikService;


    @GetMapping(value = {"", "/"})
    public ResponseEntity<List<StudentDTO>> getAll(){
        List<StudentDTO> studentDTOS = new ArrayList<>();
        List<Student> students = studentService.getAll();
        for (Student s : students){
            studentDTOS.add(new StudentDTO(s));
        }

        return new ResponseEntity<List<StudentDTO>>(studentDTOS, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<StudentDTO> getOne(@PathVariable("id") Long id) {
        Student student = studentService.getOne(id);
        Korisnik korisnik = new Korisnik();
        KorisnikDTO kdto = new KorisnikDTO();
        if(student.getKorisnik()!=null) {
        	korisnik = korisnikService.getOne(student.getKorisnik().getId());
        	kdto = new KorisnikDTO(korisnik);
        }
//        Korisnik korisnik = korisnikService.getOne(student.getKorisnik().getId());

        StudentDTO studentDTO = new StudentDTO(student, kdto);

        return new ResponseEntity<StudentDTO>(studentDTO, HttpStatus.OK);
    }

    @PostMapping(value = {"", "/"})
    public ResponseEntity<StudentDTO> create(@RequestBody StudentDTO s){
        Student student = new Student();
        student.setIme(s.getIme());
        student.setPrezime(s.getPrezime());
        student.setJMBG(s.getJMBG());
        student.setMestoStanovanja(s.getMestoStanovanja());
        student.setSmer(s.getSmer());
        student.setBrIndeksa(s.getBrIndeksa());

        student = studentService.create(student);
        return new ResponseEntity<StudentDTO>(new StudentDTO(student), HttpStatus.CREATED);
    }


    @PutMapping(value = {"", "/"}, consumes = "application/json")
    public ResponseEntity<StudentDTO> update(@RequestBody StudentDTO s){
        System.out.println(s.toString());
        Student student = studentService.getOne(s.getId());
        student.setIme(s.getIme());
        student.setPrezime(s.getPrezime());
        student.setJMBG(s.getJMBG());
        student.setMestoStanovanja(s.getMestoStanovanja());
        student.setSmer(s.getSmer());
        student.setBrIndeksa(s.getBrIndeksa());

        student = studentService.create(student);
        return new ResponseEntity<StudentDTO>(new StudentDTO(student), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        Student student = studentService.getOne(id);
        if(student == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        studentService.delete(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
