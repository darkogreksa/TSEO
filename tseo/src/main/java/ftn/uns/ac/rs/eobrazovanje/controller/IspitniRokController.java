package ftn.uns.ac.rs.eobrazovanje.controller;

import java.util.ArrayList;
import java.util.List;

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

import ftn.uns.ac.rs.eobrazovanje.dto.IspitniRokDTO;
import ftn.uns.ac.rs.eobrazovanje.model.IspitniRok;
import ftn.uns.ac.rs.eobrazovanje.servis.IspitniRokService;

@RestController
@RequestMapping("/api/ispitni-rok")
public class IspitniRokController {
	
	@Autowired
	IspitniRokService irService;
	
	@GetMapping
	public ResponseEntity<List<IspitniRokDTO>> getAll(){
		List<IspitniRokDTO> iDTO = new ArrayList<>();
		List<IspitniRok> ir = irService.getAll();
		for(IspitniRok i : ir) {
			iDTO.add(new IspitniRokDTO(i));
		}
		return new ResponseEntity<List<IspitniRokDTO>>(iDTO, HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<IspitniRokDTO> getOne(@PathVariable("id") Long id){
		IspitniRok ir = irService.getOne(id);
		if(ir == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<IspitniRokDTO>(new IspitniRokDTO(ir), HttpStatus.OK);
		}
	}
	
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<IspitniRokDTO> create(@RequestBody IspitniRokDTO irDTO){
		IspitniRok ir = new IspitniRok();
		ir.setNaziv(irDTO.getNaziv());
		ir.setDatumPocetka(irDTO.getDatumPocetka());
		ir.setDatumZavrsetka(irDTO.getDatumZavrsetka());
		ir = irService.save(ir);
		return new ResponseEntity<IspitniRokDTO>(new IspitniRokDTO(ir), HttpStatus.CREATED);
	}
	
	
	@PutMapping(value = "/{id}", consumes = "application/json")
	public ResponseEntity<IspitniRokDTO> update(@PathVariable("id") Long id, @RequestBody IspitniRokDTO irDTO){
		IspitniRok ir = irService.getOne(id);
		if (ir == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			ir.setNaziv(irDTO.getNaziv());
			ir.setDatumPocetka(irDTO.getDatumPocetka());
			ir.setDatumZavrsetka(irDTO.getDatumZavrsetka());
			ir = irService.save(ir);
			return new ResponseEntity<IspitniRokDTO>(new IspitniRokDTO(ir), HttpStatus.OK);
		}
	}
	
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id){
		IspitniRok ir = irService.getOne(id);
		if (ir == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			irService.deleteById(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}
	
	
	
	
	
	
	
	
	

}
