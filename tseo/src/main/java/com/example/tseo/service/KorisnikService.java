package com.example.tseo.service;

import com.example.tseo.model.Korisnik;
import com.example.tseo.repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KorisnikService extends CrudService<Korisnik, KorisnikRepository, Long> {

    @Autowired
    KorisnikRepository korisnikRepository;

    public Korisnik findByUsername(String username) {
        return korisnikRepository.findByKorisnickoIme(username);
    }
}
