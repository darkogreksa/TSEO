package ftn.uns.ac.rs.eobrazovanje.dto;

import ftn.uns.ac.rs.eobrazovanje.model.Predmet;
import ftn.uns.ac.rs.eobrazovanje.model.Smer;

public class PredmetDTO {

	private Long id;
	private String naziv;
	private Integer espb;
	private String sifraPredmeta;
	private Smer smer;
	private Integer godina;

	public PredmetDTO() {
	}

	public PredmetDTO(Long id, String naziv, Integer espb, String sifraPredmeta, Smer smer, Integer godina) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.espb = espb;
		this.sifraPredmeta = sifraPredmeta;
		this.smer = smer;
		this.godina = godina;
	}
	
	public PredmetDTO(Predmet predmet) {
		this(predmet.getId(), predmet.getNaziv(), predmet.getEspb(), predmet.getSifraPredmeta(), predmet.getSmer(), predmet.getGodina());
	}

	public Smer getSmer() {
		return smer;
	}

	public void setSmer(Smer smer) {
		this.smer = smer;
	}

	public Integer getGodina() {
		return godina;
	}

	public void setGodina(Integer godina) {
		this.godina = godina;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Integer getEspb() {
		return espb;
	}

	public void setEspb(Integer espb) {
		this.espb = espb;
	}

	public String getSifraPredmeta() {
		return sifraPredmeta;
	}

	public void setSifraPredmeta(String sifraPredmeta) {
		this.sifraPredmeta = sifraPredmeta;
	}

}
