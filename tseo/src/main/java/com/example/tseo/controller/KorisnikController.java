package com.example.tseo.controller;

import com.example.tseo.dto.KorisnikDTO;
import com.example.tseo.model.Korisnik;
import com.example.tseo.service.KorisnikService;
import com.example.tseo.service.NastavnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/korisnik")
public class KorisnikController {
	
	@Autowired
	KorisnikService korisnikService;
	
	@Autowired
	NastavnikService nservice;

	@GetMapping(value = "/all")
	public ResponseEntity<List<KorisnikDTO>> getAll(){
		List<KorisnikDTO> korisniciDTO = new ArrayList<>();
		List<Korisnik> korisnici = korisnikService.getAll();
		for(Korisnik k : korisnici) {
			korisniciDTO.add(new KorisnikDTO(k));
		}
		return new ResponseEntity<List<KorisnikDTO>>(korisniciDTO, HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<KorisnikDTO> getOne(@PathVariable("id") Long id){
		Korisnik k = korisnikService.getOne(id);
		return new ResponseEntity<KorisnikDTO>(new KorisnikDTO(k), HttpStatus.OK);
	}
	

	@PutMapping(value = "/{id}", consumes = "application/json")
	public ResponseEntity<KorisnikDTO> update(@PathVariable("id") Long id, @RequestBody KorisnikDTO kDTO){
		Korisnik k = korisnikService.getOne(id);
		if (k == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			k.setKorisnickoIme(kDTO.getKorisnickoIme());
			k.setLozinka(kDTO.getLozinka());
			k = korisnikService.save(k);
			return new ResponseEntity<KorisnikDTO>(new KorisnikDTO(k), HttpStatus.OK);
		}
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id){
		Korisnik k = korisnikService.getOne(id);
		if (k == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			korisnikService.deleteById(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}
	

	
	

}
