package ftn.uns.ac.rs.eobrazovanje.dto;

import java.util.Date;

import ftn.uns.ac.rs.eobrazovanje.model.Ispit;
import ftn.uns.ac.rs.eobrazovanje.model.IspitniRok;
import ftn.uns.ac.rs.eobrazovanje.model.Predmet;

public class IspitZaNastavnikaDTO {

    private Long id;
    private String vrsta;
    private Date datum;
    private String ucionica;
    private String predmet;
    private String rok;

    public IspitZaNastavnikaDTO(Long id, String vrsta, Date datum, String ucionica, String predmet, String rok) {
        super();
        this.id = id;
        this.vrsta = vrsta;
        this.datum = datum;
        this.ucionica = ucionica;
        this.predmet = predmet;
        this.rok = rok;
    }

    public IspitZaNastavnikaDTO() {
    }

    public IspitZaNastavnikaDTO(Ispit ispit) {
        this(ispit.getId(), ispit.getVrsta(), ispit.getDatum(), ispit.getUcionica(), ispit.getPredmet().getNaziv(), ispit.getRok().getNaziv());
    }

    public String getPredmet() {
        return predmet;
    }

    public void setPredmet(String predmet) {
        this.predmet = predmet;
    }

    public String getRok() {
        return rok;
    }

    public void setRok(String rok) {
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

}
