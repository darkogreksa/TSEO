package ftn.uns.ac.rs.eobrazovanje.controller;

import ftn.uns.ac.rs.eobrazovanje.dto.IspitDTO;
import ftn.uns.ac.rs.eobrazovanje.dto.IspitZaNastavnikaDTO;
import ftn.uns.ac.rs.eobrazovanje.dto.IspitZaOcenjivanjeDTO;
import ftn.uns.ac.rs.eobrazovanje.dto.PredmetDTO;
import ftn.uns.ac.rs.eobrazovanje.model.Ispit;
import ftn.uns.ac.rs.eobrazovanje.model.IspitniRok;
import ftn.uns.ac.rs.eobrazovanje.model.Nastavnik;
import ftn.uns.ac.rs.eobrazovanje.repository.IspitRepository;
import ftn.uns.ac.rs.eobrazovanje.repository.IspitniRokRepository;
import ftn.uns.ac.rs.eobrazovanje.repository.PredmetRepository;
import ftn.uns.ac.rs.eobrazovanje.servis.IspitService;
import ftn.uns.ac.rs.eobrazovanje.servis.NastavnikService;
import ftn.uns.ac.rs.eobrazovanje.servis.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/ispit")
public class IspitController {

    @Autowired
    IspitRepository ispitRepository;

    @Autowired
    PredmetRepository predmetRepository;

    @Autowired
    NastavnikService nastavnikService;
    
    @Autowired
    StudentService studentService;
    
    @Autowired
    IspitService ispitService;

    @Autowired
    IspitniRokRepository ispitniRokRepository;

    @GetMapping(value = "/all")
    public ResponseEntity<List<IspitDTO>> getAll(){
        List<IspitDTO> ispiti = ispitService.getAll();
        return new ResponseEntity<List<IspitDTO>>(ispiti, HttpStatus.OK);
    }
    
    @GetMapping
	@RequestMapping(value = "/{page}/{size}")
    public ResponseEntity<Page<IspitDTO>> getAllPage(@PathVariable("page") Integer page,
			@PathVariable("size") Integer size) {
        Page<IspitDTO> ispiti = ispitService.getAllPage(page, size);
        return new ResponseEntity<Page<IspitDTO>>(ispiti, HttpStatus.OK);
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
    
    @PutMapping(value = "/update")
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

    @GetMapping(value = "/nastavnik/{nastavnikId}")
    public ResponseEntity<List<IspitZaNastavnikaDTO>> getAllByNastavnik(@PathVariable("nastavnikId") Long id) {
        Nastavnik nastavnik = nastavnikService.getOne(id);

        if (nastavnik == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        List<Ispit> ispiti = ispitRepository.getAllZaNastavnika(nastavnik);
        List<IspitZaNastavnikaDTO> ispitDTOs = new ArrayList<IspitZaNastavnikaDTO>();
        for (Ispit isp : ispiti) {
            IspitZaNastavnikaDTO dto = new IspitZaNastavnikaDTO(isp);
            ispitDTOs.add(dto);
        }

        // uzeti trenutni rok od nekud...
        //nastavnikService.getIspitiZaOcenjivanje(nastavnik, rok?)

        return new ResponseEntity<List<IspitZaNastavnikaDTO>>(ispitDTOs, HttpStatus.OK);

    }
    @GetMapping(value = "/kolokvijum/nastavnik/{nastavnikId}")
    public ResponseEntity<List<IspitZaNastavnikaDTO>> getAllKolokvijumiByNastavnik(@PathVariable("nastavnikId") Long id) {
        Nastavnik nastavnik = nastavnikService.getOne(id);

        if (nastavnik == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        List<Ispit> ispiti = ispitRepository.getAllKolokvijumiZaNastavnika(nastavnik);
        List<IspitZaNastavnikaDTO> ispitDTOs = new ArrayList<IspitZaNastavnikaDTO>();
        for (Ispit isp : ispiti) {
            IspitZaNastavnikaDTO dto = new IspitZaNastavnikaDTO(isp);
            ispitDTOs.add(dto);
        }

        // uzeti trenutni rok od nekud...
        //nastavnikService.getIspitiZaOcenjivanje(nastavnik, rok?)

        return new ResponseEntity<List<IspitZaNastavnikaDTO>>(ispitDTOs, HttpStatus.OK);

    }
    @GetMapping(value = "/ocenjivanje/nastavnik/{nastavnikId}")
    public ResponseEntity<List<IspitZaNastavnikaDTO>> getAllIspitiForGradingByNastavnik(@PathVariable("nastavnikId") Long nastavnikId){
        Nastavnik nastavnik = nastavnikService.getOne(nastavnikId);
        if (nastavnik == null)
            return new ResponseEntity<List<IspitZaNastavnikaDTO>>(HttpStatus.BAD_REQUEST);

        List<IspitZaNastavnikaDTO> ispiti = nastavnikService.getIspitiZaOcenjivanjeSviRokovi(nastavnik);

        return new ResponseEntity<List<IspitZaNastavnikaDTO>>(ispiti, HttpStatus.OK);
    }

    //dobavlja sve ispite za koje je potrebno oceniti radove (iz predmeta koje dati nastavnik izvodi)
    @GetMapping(value = "/ocenjivanje/nastavnik/{nastavnikId}/rok/{rokId}")
    public ResponseEntity<List<IspitZaOcenjivanjeDTO>> getAllIspitiForGradingByRokAndNastavnik(@PathVariable("nastavnikId") Long nastavnikId, @PathVariable("rokId") Long rokId){
        Nastavnik nastavnik = nastavnikService.getOne(nastavnikId);
        if (nastavnik == null)
            return new ResponseEntity<List<IspitZaOcenjivanjeDTO>>(HttpStatus.BAD_REQUEST);


        IspitniRok rok = ispitniRokRepository.getOne(rokId);
        if (rok == null)
            return new ResponseEntity<List<IspitZaOcenjivanjeDTO>>(HttpStatus.BAD_REQUEST);


        List<IspitZaOcenjivanjeDTO> ispiti = nastavnikService.getIspitiZaOcenjivanje(nastavnik, rok);

        return new ResponseEntity<List<IspitZaOcenjivanjeDTO>>(ispiti, HttpStatus.OK);
    }
    
//    @GetMapping(value = "/nepolozeni/{studentId}")
//    public ResponseEntity<List<IzlazakDTO>> getAllNepolozeniByStudent(@PathVariable("studentId") Long studentId){
//    	Student student = studentService.getOne(studentId);
//    	if (student == null) {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		} else {
//			Set<IzlazakNaIspit> izlasci = new HashSet<>();
//			for(IzlazakNaIspit i : izlasci) {
//				if(i.getStudent().getId() == studentId) {
//					if(!i.getPolozio()) {
//						izlasci.add(i);
//					}
//				}
//			}
//			return new ResponseEntity<>(izlasci, HttpStatus.OK);
//		}
//    }
    
    
    
    
    
    
    
    

}
