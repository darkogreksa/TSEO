package com.example.tseo.service;

import com.example.tseo.dto.PredmetDTO;
import com.example.tseo.model.Predmet;
import com.example.tseo.model.Student;
import com.example.tseo.repository.PredmetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PredmetService {
	@Autowired
	PredmetRepository predmetRepository;

	public List<PredmetDTO> getAll() {
		List<PredmetDTO> p = predmetRepository.findAll().stream().map(predmet -> new PredmetDTO(predmet))
				.collect(Collectors.toList());
		return p;
	}

	public PredmetDTO getById(Long id) {
		Predmet predmet = predmetRepository.getOne(id);
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
			predmet.setGodina(2021);
			predmet.setSmer(predmetDTO.getSmer());
			predmetRepository.save(predmet);
			return true;
		}
		else {
			return false;
		}
	}

	public boolean deletePredmet(Long id) {
		Predmet predmet = predmetRepository.getOne(id);
		try {
			predmetRepository.delete(predmet);
			return true;
		}
		catch (Exception e) {
			return false;
		}

	}
	
}
