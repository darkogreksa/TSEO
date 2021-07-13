package ftn.uns.ac.rs.eobrazovanje.servis;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import ftn.uns.ac.rs.eobrazovanje.dto.PredmetDTO;
import ftn.uns.ac.rs.eobrazovanje.model.Predmet;
import ftn.uns.ac.rs.eobrazovanje.repository.PredmetRepository;

@Service
public class PredmetService {

	@Autowired
	PredmetRepository predmetRepo;
	
	public List<PredmetDTO> getAll() {
		List<PredmetDTO> p = predmetRepo.findAll().stream().map(predmet -> new PredmetDTO(predmet))
				.collect(Collectors.toList());
		return p;
	}
	
	public Page<PredmetDTO> getAllPage(Integer page, Integer size) {
		PageRequest pr = PageRequest.of(page, size);
		Page<Predmet> p = predmetRepo.findAll(pr);
		Page<PredmetDTO> pDTO = p.map(PredmetDTO::new);
		return pDTO;
	}

	public PredmetDTO getById(Long id) {
		Predmet predmet = predmetRepo.getOne(id);
		if (predmet == null)
			return null;
		else
			return new PredmetDTO(predmet);
	}

	public boolean addPredmet(PredmetDTO predmetDTO) {
		if(predmetDTO != null) {
			Predmet predmet = new Predmet();
			predmet.setEspb(predmetDTO.getEspb());
			predmet.setNaziv(predmetDTO.getNaziv());
			predmet.setSifraPredmeta(predmetDTO.getSifraPredmeta());
			predmet.setGodina(2019);
			predmet.setSmer(predmetDTO.getSmer());
			predmetRepo.save(predmet);
			return true;
		}
		else {
			return false;
		}
	}

	public boolean deletePredmet(Long id) {
		Predmet predmet = predmetRepo.getOne(id);
		try {
			predmetRepo.delete(predmet);
			return true;
		}
		catch (Exception e) {
			return false;
		}
		
	}

	
}
