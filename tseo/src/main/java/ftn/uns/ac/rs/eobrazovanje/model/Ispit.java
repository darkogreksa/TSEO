package ftn.uns.ac.rs.eobrazovanje.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "ispit")
public class Ispit {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "vrsta")
	private String vrsta;

	@Column(name = "datum")
	private Date datum;
	
	@Column(name = "ucionica")
	private String ucionica;

	@ManyToOne()
	@JoinColumn(name = "predmet_id", referencedColumnName = "id")
	private Predmet predmet;

	@ManyToOne()
	@JoinColumn(name = "rok_id", referencedColumnName = "id")
	private IspitniRok rok;

	@OneToMany(mappedBy = "ispit")
	private List<IzlazakNaIspit> izlasci;

	public Ispit(){

	}

	public Ispit(Long id, String vrsta, Date datum, String ucionica, Predmet predmet, IspitniRok rok) {
		super();
		this.id = id;
		this.vrsta = vrsta;
		this.datum = datum;
		this.ucionica = ucionica;
		this.predmet = predmet;
		this.rok = rok;
	}

	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}

	public void setRok(IspitniRok rok) {
		this.rok = rok;
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

	public Predmet getPredmet() {
		return predmet;
	}

	public IspitniRok getRok() {
		return rok;
	}

	public List<IzlazakNaIspit> getIzlasci() {
		return izlasci;
	}

	@Override
	public String toString() {
		return "Ispit{" +
				"id=" + id +
				", vrsta='" + vrsta + '\'' +
				", datum=" + datum +
				", ucionica='" + ucionica + '\'' +
				'}';
	}
}
