package com.example.tseo.controller;

import com.example.tseo.dto.PredmetDTO;
import com.example.tseo.model.IzlazakNaIspit;
import com.example.tseo.model.Nastavnik;
import com.example.tseo.model.Predmet;
import com.example.tseo.model.Student;
import com.example.tseo.repository.PredmetRepository;
import com.example.tseo.service.IzlazakNaIspitService;
import com.example.tseo.service.NastavnikService;
import com.example.tseo.service.PredmetService;
import com.example.tseo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/api/predmet")
public class PredmetController {

	@Autowired
    PredmetService predmetService;
	
    @Autowired
    PredmetRepository predmetRepository;

    @Autowired
    NastavnikService nastavnikService;

    @Autowired
    IzlazakNaIspitService izlazakService;

    @Autowired
    StudentService studentService;
    
    @GetMapping(value = "/all")
    public ResponseEntity<List<PredmetDTO>> getAll(){
        List<PredmetDTO> predmeti = predmetService.getAll();
        return new ResponseEntity<List<PredmetDTO>>(predmeti, HttpStatus.OK);
    }

    
    @GetMapping(value = "/{id}")
    public ResponseEntity<PredmetDTO> getById(@PathVariable("id") Long id){
    	PredmetDTO predmet = predmetService.getById(id);
        if(predmet == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<PredmetDTO>(predmet, HttpStatus.OK);
    }
    
    @PostMapping(value = "/add")
    public ResponseEntity<PredmetDTO> addPredmet(@RequestBody PredmetDTO predmetDTO){
    	if(predmetService.addPredmet(predmetDTO)) {
    		return new ResponseEntity<>(HttpStatus.CREATED);
    	}
    	else {
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	}
    }
    
    @PutMapping(value = "/update")
	public ResponseEntity<HttpStatus> update(@RequestBody PredmetDTO predmetDTO) {
    	if(predmetService.addPredmet(predmetDTO)) {
    		return new ResponseEntity<>(HttpStatus.CREATED);
    	}
    	else {
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	}
    }
    
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
    	if(predmetService.deletePredmet(id)) {
    		return new ResponseEntity<>(HttpStatus.CREATED);
    	}
    	else {
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	}
    }


    @GetMapping(value = "/nastavnik/{nastavnikId}")
    public ResponseEntity<List<Predmet>> getAllKojeNastavnikIzvodi(@PathVariable("nastavnikId") Long id) {
        Nastavnik nastavnik = nastavnikService.getOne(id);

        List<Predmet> predmeti =predmetRepository.getAllThatNastavnikIzvodi(nastavnik);

        System.out.println(predmeti);

        return new ResponseEntity<List<Predmet>>(predmeti, HttpStatus.OK);
    }

    @GetMapping(value = "/nepolozeni/{studentId}")
    public ResponseEntity<Set<PredmetDTO>> getAllNepolozeni(@PathVariable("studentId") Long studentId){
//        List<PredmetDTO> predmeti = predmetService.getAll();
        Set<PredmetDTO> predmeti = new HashSet<PredmetDTO>();
        Student s = studentService.getOne(studentId);
        List<IzlazakNaIspit> izlasci = izlazakService.getAll();

        for(IzlazakNaIspit i : izlasci) {
            if(i.getStudent().getId() == studentId) {
                System.out.println("true false dal je polozio: " + i.getPolozio());
                if(!i.getPolozio()) {
                    predmeti.add(new PredmetDTO(i.getIspit().getPredmet()));
                }
            }
        }

        return new ResponseEntity<Set<PredmetDTO>>(predmeti, HttpStatus.OK);
    }
    
    
}
