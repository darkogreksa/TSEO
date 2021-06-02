package com.example.tseo.service;

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

	public List<Predmet> getAll() {
		return predmetRepository.findAll();
	}

	public Predmet getOne(Long id) {
		return predmetRepository.findById(id).orElse(null);
	}

	public Predmet create(Predmet s){
		return predmetRepository.save(s);
	}

	public void delete(Long id){
		predmetRepository.deleteById(id);
	}
	
}
