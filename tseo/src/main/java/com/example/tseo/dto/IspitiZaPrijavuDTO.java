package com.example.tseo.dto;

import com.example.tseo.model.Ispit;

import java.util.Date;

public class IspitiZaPrijavuDTO {

    private Long id;
    private String naziv;
    private Date datum;
    //    private Date vreme;
    private String ucionica;


    public IspitiZaPrijavuDTO(Long id, String naziv, Date datum, String ucionica) {
        super();
        this.id = id;
        this.naziv = naziv;
        this.datum = datum;
//		this.vreme = vreme;
        this.ucionica = ucionica;
    }


    public IspitiZaPrijavuDTO(Ispit ispit){
        this(ispit.getId(), ispit.getPredmet().getNaziv(), ispit.getDatum(), ispit.getUcionica());
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

//	public Date getVreme() {
//		return vreme;
//	}
//
//	public void setVreme(Date vreme) {
//		this.vreme = vreme;
//	}

    public String getUcionica() {
        return ucionica;
    }

    public void setUcionica(String ucionica) {
        this.ucionica = ucionica;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

}

