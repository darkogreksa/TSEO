package ftn.uns.ac.rs.eobrazovanje.dto;

import java.util.Date;

import ftn.uns.ac.rs.eobrazovanje.model.IspitniRok;

public class IspitniRokDTO {
	
	private Long id;
	private String naziv;
	private Date datumPocetka;
	private Date datumZavrsetka;
	
	public IspitniRokDTO() {
		
	}
	

	public IspitniRokDTO(IspitniRok ir) {
		this(ir.getId(), ir.getNaziv(), ir.getDatumPocetka(), ir.getDatumZavrsetka());
	}
	
	public IspitniRokDTO(Long id, String naziv, Date datumPocetka, Date datumZavrsetka) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.datumPocetka = datumPocetka;
		this.datumZavrsetka = datumZavrsetka;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDatumPocetka() {
		return datumPocetka;
	}

	public void setDatumPocetka(Date datumPocetka) {
		this.datumPocetka = datumPocetka;
	}

	public Date getDatumZavrsetka() {
		return datumZavrsetka;
	}

	public void setDatumZavrsetka(Date datumZavrsetka) {
		this.datumZavrsetka = datumZavrsetka;
	}


	public String getNaziv() {
		return naziv;
	}


	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
	

}
