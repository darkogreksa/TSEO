package ftn.uns.ac.rs.eobrazovanje.dto;

import ftn.uns.ac.rs.eobrazovanje.model.IzlazakNaIspit;

public class IzlazakDTO {
	
	private Long id;
	private Integer bodovi;
	private Boolean polozio;
	private Integer ocena;
	private StudentDTO student;
	private IspitDTO ispit;
	
	public IzlazakDTO() {
		
	}

	public IzlazakDTO(Long id, Integer bodovi, Boolean polozio, Integer ocena, StudentDTO student, IspitDTO ispit) {
		super();
		this.id = id;
		this.bodovi = bodovi;
		this.polozio = polozio;
		this.ocena = ocena;
		this.student = student;
		this.ispit = ispit;
	}
	
	public IzlazakDTO(IzlazakNaIspit i) {
		this(i.getId(), i.getBodovi(), i.getPolozio(), i.getOcena(), new StudentDTO(i.getStudent()), new IspitDTO(i.getIspit()));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getBodovi() {
		return bodovi;
	}

	public void setBodovi(Integer bodovi) {
		this.bodovi = bodovi;
	}

	public Boolean getPolozio() {
		return polozio;
	}

	public void setPolozio(Boolean polozio) {
		this.polozio = polozio;
	}

	public Integer getOcena() {
		return ocena;
	}

	public void setOcena(Integer ocena) {
		this.ocena = ocena;
	}

	public StudentDTO getStudent() {
		return student;
	}

	public void setStudent(StudentDTO student) {
		this.student = student;
	}

	public IspitDTO getIspit() {
		return ispit;
	}

	public void setIspit(IspitDTO ispit) {
		this.ispit = ispit;
	}
	
	
}
