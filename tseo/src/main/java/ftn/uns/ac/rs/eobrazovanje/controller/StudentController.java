package ftn.uns.ac.rs.eobrazovanje.controller;

import ftn.uns.ac.rs.eobrazovanje.dto.IzlazakDTO;
import ftn.uns.ac.rs.eobrazovanje.dto.IzlazakPolozioDTO;
import ftn.uns.ac.rs.eobrazovanje.dto.KorisnikDTO;
import ftn.uns.ac.rs.eobrazovanje.dto.StudentDTO;
import ftn.uns.ac.rs.eobrazovanje.model.IzlazakNaIspit;
import ftn.uns.ac.rs.eobrazovanje.model.Korisnik;
import ftn.uns.ac.rs.eobrazovanje.model.PohadjanjePredmeta;
import ftn.uns.ac.rs.eobrazovanje.model.Predmet;
import ftn.uns.ac.rs.eobrazovanje.model.Student;
import ftn.uns.ac.rs.eobrazovanje.repository.IzlazakRepository;
import ftn.uns.ac.rs.eobrazovanje.servis.KorisnikService;
import ftn.uns.ac.rs.eobrazovanje.servis.PohadjanjePredmetaService;
import ftn.uns.ac.rs.eobrazovanje.servis.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    PohadjanjePredmetaService pohadjanjePredmetaService;
    
    @Autowired
    KorisnikService korisnikService;

    @Autowired
    IzlazakRepository izlazakRepository;

    @GetMapping(value = {"", "/"})
    public ResponseEntity<List<StudentDTO>> getAll(){
        List<StudentDTO> studentDTOS = new ArrayList<>();
        List<Student> students = studentService.getAll();
        for (Student s : students){
            studentDTOS.add(new StudentDTO(s));
        }

        return new ResponseEntity<List<StudentDTO>>(studentDTOS, HttpStatus.OK);
    }

    @GetMapping(value = "/{page}/{size}")
    public ResponseEntity<Page<Student>> getAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        Page<Student> studenti = studentService.findAllPaged(page, size);
        if (studenti == null)
            return new ResponseEntity<Page<Student>>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<Page<Student>>(studenti, HttpStatus.OK);
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
        System.out.println("STUDENT " + s.toString());
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

    @GetMapping(value = "/ime/{ime}")
    public ResponseEntity<List<StudentDTO>> findAllByIme(@PathVariable("ime") String ime){
        List<Student> studenti = studentService.findAllByIme(ime);
        List<StudentDTO> studentDTOS = new ArrayList<>();
        for (Student s : studenti){
            studentDTOS.add(new StudentDTO(s));
        }
        if(studenti == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<StudentDTO>>(studentDTOS, HttpStatus.OK);
    }

    @GetMapping(value = "/pohadja/{studentId}")
    public ResponseEntity<List<PohadjanjePredmeta>> studentPohadja(@PathVariable("studentId") Long studentId){
        List<PohadjanjePredmeta> pohadjanje = pohadjanjePredmetaService.getAllByStudent_Id(studentId);
        if(pohadjanje == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<List<PohadjanjePredmeta>>(pohadjanje, HttpStatus.OK);
    }
    
    @GetMapping(value = "/nepolozeni/{studentId}")
    public ResponseEntity<List<Predmet>> studentNijePolozio(@PathVariable("studentId") Long studentId){
        List<PohadjanjePredmeta> pohadjanje = pohadjanjePredmetaService.getAllByStudent_Id(studentId);
        List<IzlazakNaIspit> polozio = izlazakRepository.findAllByStudentIdAndPolozioTrue(studentId);
        
        List<Predmet> polozeni = new ArrayList<Predmet>();
        List<Predmet> nepolozeni = new ArrayList<Predmet>();
        for(PohadjanjePredmeta pp : pohadjanje) {
        	nepolozeni.add(pp.getIzvedba().getPredmet());
        	for(IzlazakNaIspit izl : polozio) {
        		if(izl.getIspit().getPredmet().getId().equals(pp.getIzvedba().getPredmet().getId())) {
        			polozeni.add(pp.getIzvedba().getPredmet());
        		}
        	}
        }
        for(PohadjanjePredmeta pp : pohadjanje) { 
        	for(Predmet p : polozeni) {
	        	if(pp.getIzvedba().getPredmet().getId().equals(p.getId())) {
	        		nepolozeni.remove(p);
	        	}
        	}
        }
        
        
        if(pohadjanje == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<List<Predmet>>(nepolozeni, HttpStatus.OK);
    }

    @GetMapping(value = "/polozio/{studentId}")
    public ResponseEntity<List<IzlazakPolozioDTO>> studentPolozio(@PathVariable("studentId") Long studentId){
        List<IzlazakNaIspit> polozio = izlazakRepository.findAllByStudentIdAndPolozioTrue(studentId);
        if(polozio == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        List<IzlazakPolozioDTO> iDTO = new ArrayList<>();
        for(IzlazakNaIspit i : polozio) {
            iDTO.add(new IzlazakPolozioDTO(i));
        }
        return new ResponseEntity<List<IzlazakPolozioDTO>>(iDTO, HttpStatus.OK);
    }
}
