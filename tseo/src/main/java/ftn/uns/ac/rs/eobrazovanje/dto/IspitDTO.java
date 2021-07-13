package ftn.uns.ac.rs.eobrazovanje.dto;

import java.util.Date;

import ftn.uns.ac.rs.eobrazovanje.model.Ispit;
import ftn.uns.ac.rs.eobrazovanje.model.IspitniRok;
import ftn.uns.ac.rs.eobrazovanje.model.Predmet;

public class IspitDTO {

	private Long id;
	private String vrsta;
	private Date datum;
	private String ucionica;
	private IspitniRok ispitniRok;
	private Predmet predmet;

	public IspitDTO(Long id, String vrsta, Date datum, String ucionica, IspitniRok ispitniRok, Predmet predmet) {
		super();
		this.id = id;
		this.vrsta = vrsta;
		this.datum = datum;
		this.ucionica = ucionica;
		this.ispitniRok = ispitniRok;
		this.predmet = predmet;
	}

	public IspitDTO() {
	}

	public IspitDTO(Ispit ispit) {
		this(ispit.getId(), ispit.getVrsta(), ispit.getDatum(), ispit.getUcionica(), ispit.getRok(), ispit.getPredmet());
	}

	public IspitniRok getIspitniRok() {
		return ispitniRok;
	}

	public void setIspitniRok(IspitniRok ispitniRok) {
		this.ispitniRok = ispitniRok;
	}

	public Predmet getPredmet() {
		return predmet;
	}

	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVrsta() {
		return vrsta;
	}

	public void setVrsta(String vrsta) {
		this.vrsta = vrsta;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public String getUcionica() {
		return ucionica;
	}

	public void setUcionica(String ucionica) {
		this.ucionica = ucionica;
	}

}
