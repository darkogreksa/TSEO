package com.example.tseo.dto;

import com.example.tseo.model.Korisnik;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

public class KorisnikDTO {
	
	private Long id;
	private String korisnickoIme;
	private String lozinka;
	private Date datum;
	private Long student;
	private Long nastavnik;

	public KorisnikDTO() {
		
	}

	public KorisnikDTO(Long id, String korisnickoIme, String lozinka, Date datum) {
		super();
		this.id = id;
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
		this.datum = datum;
	}
	
	
	public KorisnikDTO(Korisnik k) {
		this(k.getId(), k.getKorisnickoIme(), k.getLozinka(), k.getDatumKreiranja());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKorisnickoIme() {
		return korisnickoIme;
	}

	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}
	
	public Long getStudent() {
		return student;
	}

	public void setStudent(Long student) {
		this.student = student;
	}

	public Long getNastavnik() {
		return nastavnik;
	}

	public void setNastavnik(Long nastavnik) {
		this.nastavnik = nastavnik;
	}

	
	

}
