package ftn.uns.ac.rs.eobrazovanje.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.uns.ac.rs.eobrazovanje.model.Korisnik;

public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {

	Korisnik findByKorisnickoIme(String username);
}
