package ftn.uns.ac.rs.eobrazovanje.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ftn.uns.ac.rs.eobrazovanje.dto.KorisnikDTO;
import ftn.uns.ac.rs.eobrazovanje.dto.LoginDTO;
import ftn.uns.ac.rs.eobrazovanje.model.Authority;
import ftn.uns.ac.rs.eobrazovanje.model.Korisnik;
import ftn.uns.ac.rs.eobrazovanje.model.Nastavnik;
import ftn.uns.ac.rs.eobrazovanje.model.Student;
import ftn.uns.ac.rs.eobrazovanje.servis.AuthorityService;
import ftn.uns.ac.rs.eobrazovanje.servis.KorisnikService;
import ftn.uns.ac.rs.eobrazovanje.servis.NastavnikService;
import ftn.uns.ac.rs.eobrazovanje.servis.StudentService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/korisnik")
public class KorisnikController {
	
	@Autowired
	KorisnikService korisnikService;
	
	@Autowired
	StudentService sservice;
	
	@Autowired
	NastavnikService nservice;
	
	@Autowired
	AuthorityService aservice;
	
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
	
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<KorisnikDTO> create(@RequestBody KorisnikDTO kDTO){
		Korisnik k = new Korisnik();
		k.setKorisnickoIme(kDTO.getKorisnickoIme());
		String sifra = "123";
		BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
		k.setLozinka(bc.encode(sifra));
		k.setDatumKreiranja(new Date());
		Set<Authority> auth = new HashSet<>();
		System.out.println(kDTO.getStudent());
		if(kDTO.getStudent()==null || kDTO.getStudent().equals(null)) {
			System.out.println("necu studenta");
			Nastavnik n = nservice.getOne(kDTO.getNastavnik());
			k.setNastavnik(n);
			Authority a = aservice.findByName("NASTAVNIK");
//			a.setName("NASTAVNIK");
			n.setKorisnik(k);
			auth.add(a);
			k.setUser_authorities(auth);
			k = korisnikService.save(k);
			nservice.create(n);
		}else {
			Student student = sservice.getOne(kDTO.getStudent());
			k.setStudent(student);
			student.setKorisnik(k);
			
			Authority a = aservice.findByName("STUDENT");
			auth.add(a);
			k.setUser_authorities(auth);
			k = korisnikService.save(k);
			sservice.create(student);
		}
		
		
//		k = korisnikService.save(k);
		return new ResponseEntity<KorisnikDTO>(new KorisnikDTO(k), HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/{id}", consumes = "application/json")
	public ResponseEntity<KorisnikDTO> update(@PathVariable("id") Long id, @RequestBody KorisnikDTO kDTO){
		Korisnik k = korisnikService.getOne(id);
		if (k == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			k.setKorisnickoIme(kDTO.getKorisnickoIme());
			k.setLozinka(kDTO.getLozinka());
//			k.setAuthority(new Authority());
//			k.setUloga(kDTO.getUloga());
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
	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Map<String, Object>> login(@RequestBody LoginDTO loginDTO) {
		return Optional.ofNullable(korisnikService.login(loginDTO))
				.map(cookie -> new ResponseEntity<Map<String, Object>>(cookie, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.UNAUTHORIZED));
	}
	
	

}
