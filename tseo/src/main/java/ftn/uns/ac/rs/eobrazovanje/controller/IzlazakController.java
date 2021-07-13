package ftn.uns.ac.rs.eobrazovanje.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ftn.uns.ac.rs.eobrazovanje.dto.*;
import ftn.uns.ac.rs.eobrazovanje.model.Nastavnik;
import ftn.uns.ac.rs.eobrazovanje.model.PohadjanjePredmeta;
import ftn.uns.ac.rs.eobrazovanje.model.Predmet;
import ftn.uns.ac.rs.eobrazovanje.model.Student;
import ftn.uns.ac.rs.eobrazovanje.servis.NastavnikService;
import ftn.uns.ac.rs.eobrazovanje.servis.PohadjanjePredmetaService;
import ftn.uns.ac.rs.eobrazovanje.servis.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ftn.uns.ac.rs.eobrazovanje.model.Ispit;
import ftn.uns.ac.rs.eobrazovanje.model.IspitniRok;
import ftn.uns.ac.rs.eobrazovanje.model.IzlazakNaIspit;
import ftn.uns.ac.rs.eobrazovanje.model.IzvedbaPredmeta;
import ftn.uns.ac.rs.eobrazovanje.model.Korisnik;
import ftn.uns.ac.rs.eobrazovanje.servis.IspitService;
import ftn.uns.ac.rs.eobrazovanje.servis.IspitniRokService;
import ftn.uns.ac.rs.eobrazovanje.servis.IzlazakService;
import ftn.uns.ac.rs.eobrazovanje.servis.KorisnikService;

@RestController
@RequestMapping("/api/izlazak")
public class IzlazakController {
	
	@Autowired
	IzlazakService izlazakService;

	@Autowired
	NastavnikService nastavnikService;
	
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
		List<IzlazakNaIspit> izlasci = izlazakService.getAll();
		for(IzlazakNaIspit i : izlasci) {
			iDTO.add(new IzlazakDTO(i));
		}
		return new ResponseEntity<List<IzlazakDTO>>(iDTO, HttpStatus.OK);
	}

	@GetMapping(value = "/ispit/{idIspita}")
	public ResponseEntity<List<IzlazakZaOcenjivanjeDTO>> getAllByIspit(@PathVariable("idIspita") Long idIspita){

		List<IzlazakZaOcenjivanjeDTO> iDTO = new ArrayList<>();
		List<IzlazakNaIspit> izlasci = izlazakService.getAllByIspitId(idIspita);

		// koristiti DTO koji sadrzi i ime i prezime studenta
		for(IzlazakNaIspit i : izlasci) {
			iDTO.add(new IzlazakZaOcenjivanjeDTO(i));
		}
		return new ResponseEntity<List<IzlazakZaOcenjivanjeDTO>>(iDTO, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<IzlazakDTO> getOne(@PathVariable("id") Long id){
		IzlazakNaIspit i = izlazakService.getOne(id);
		if(i == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<IzlazakDTO>(new IzlazakDTO(i), HttpStatus.OK);
		}
	}
	
	@PostMapping(value = "/{student}/{ispit}", consumes = "application/json")
	public ResponseEntity<IzlazakDTO> create(@RequestBody IzlazakDTO iDTO, @PathVariable("student") Long s, @PathVariable("ispit") Long ispit){
		IzlazakNaIspit i = new IzlazakNaIspit();
		Student student = studentService.getOne(s);
		Ispit is = new Ispit();
		IspitDTO dto = ispitService.getById(ispit);
		is.setId(dto.getId());
		is.setDatum(dto.getDatum());
		is.setPredmet(dto.getPredmet());
		is.setUcionica(dto.getUcionica());
		is.setVrsta(dto.getVrsta());
		is.setRok(dto.getIspitniRok());
		
		i.setIspit(is);
		i.setStudent(student);
		i.setOcena(0);
		i.setBodovi(0);
		i.setPolozio(false);
		i = izlazakService.save(i);
		return new ResponseEntity<IzlazakDTO>(new IzlazakDTO(i), HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/{id}", consumes = "application/json")
	public ResponseEntity<IzlazakDTO> update(@PathVariable("id") Long id, @RequestBody IzlazakDTO iDTO){
		IzlazakNaIspit i = izlazakService.getOne(id);
		if(i == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			i.setBodovi(iDTO.getBodovi());
			i.setOcena(iDTO.getOcena());
			i.setPolozio(iDTO.getPolozio());
			i = izlazakService.save(i);
			return new ResponseEntity<IzlazakDTO>(new IzlazakDTO(i), HttpStatus.OK);
		}
	}

//	@PostMapping(value = "/ispit/{idIspita}", consumes = "application/json")
//	public ResponseEntity<List<IzlazakDTO>>
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id){
		IzlazakNaIspit i = izlazakService.getOne(id);
		if(i == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			izlazakService.deleteById(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}
	
	@GetMapping(value = "/student/{id}")
	public ResponseEntity<List<IzlazakPolozioDTO>> studentPolozio(@PathVariable("id") Long id){
		List<IzlazakNaIspit> polozio = izlazakService.getAllByStudentNijePolozio(id);
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
//		Student student = studentService.getOne(id);
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
			List<IzlazakNaIspit> polozio = izlazakService.getAllByStudentPolozio(student.getId());
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
