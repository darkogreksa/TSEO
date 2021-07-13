package ftn.uns.ac.rs.eobrazovanje.servis;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import ftn.uns.ac.rs.eobrazovanje.dto.IspitDTO;
import ftn.uns.ac.rs.eobrazovanje.dto.IspitiZaPrijavuDTO;
import ftn.uns.ac.rs.eobrazovanje.model.Ispit;
import ftn.uns.ac.rs.eobrazovanje.model.IspitniRok;
import ftn.uns.ac.rs.eobrazovanje.model.Predmet;
import ftn.uns.ac.rs.eobrazovanje.model.Student;
import ftn.uns.ac.rs.eobrazovanje.repository.IspitRepository;

@Service
public class IspitService {

	@Autowired
	IspitRepository ispitRepo;

	public List<IspitDTO> getAll() {
		List<IspitDTO> i = ispitRepo.findAll().stream().map(ispit -> new IspitDTO(ispit))
				.collect(Collectors.toList());
		return i;
	}

	public IspitDTO getById(Long id) {
		Ispit ispit = ispitRepo.getOne(id);
		if (ispit == null)
			return null;
		else
			return new IspitDTO(ispit);
	}

	public boolean addIspit(IspitDTO ispitDTO) {
		if(ispitDTO != null) {
			Ispit ispit = new Ispit();
			ispit.setUcionica(ispitDTO.getUcionica());
			ispit.setDatum(ispitDTO.getDatum());
			ispit.setVrsta(ispitDTO.getVrsta());
			ispit.setPredmet(ispitDTO.getPredmet());
			System.out.println(ispitDTO.getIspitniRok());
			ispit.setRok(ispitDTO.getIspitniRok());
			ispitRepo.save(ispit);
			return true;
		}
		else {
			return false;
		}
	}

	public boolean deletePredmet(Long id) {
		Ispit ispit = ispitRepo.getOne(id);
		try {
			ispitRepo.delete(ispit);
			return true;
		}
		catch (Exception e) {
			return false;
		}
		
	}

	public Page<IspitDTO> getAllPage(Integer page, Integer size) {
		PageRequest pr = PageRequest.of(page, size);
		Page<Ispit> i = ispitRepo.findAll(pr);
		Page<IspitDTO> pDTO = i.map(IspitDTO::new);
		return pDTO;
	}

	public List<Ispit> getAllByRokAndPredmet(IspitniRok rok, Predmet predmet) {
		return ispitRepo.getAllByRokAndPredmet(rok, predmet);
	}
	
//	public List<IspitiZaPrijavuDTO> getAllIspitiZaPrijavu(Student s, IspitniRok ir){
//		return ispitRepo.getAllIspitiZaPrijavu(s, ir);
//	}
	
}
