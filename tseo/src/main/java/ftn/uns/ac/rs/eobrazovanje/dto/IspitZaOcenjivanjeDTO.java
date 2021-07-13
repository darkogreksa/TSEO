package ftn.uns.ac.rs.eobrazovanje.dto;


import java.util.Date;

public class IspitZaOcenjivanjeDTO {
    public Long idIspit;
    public Date datum;
    public Long idPredmet;
    public String sifra;
    public String naziv;
    public String vrsta;

    public IspitZaOcenjivanjeDTO() {
    }

    //potreban konstruktor za kreiranje objekta iz jpql izraza
    public IspitZaOcenjivanjeDTO(Long idIspit, Date datum, Long idPredmet, String sifra, String naziv, String vrsta) {
        this.idIspit = idIspit;
        this.datum = datum;
        this.idPredmet = idPredmet;
        this.sifra = sifra;
        this.naziv = naziv;
        this.vrsta = vrsta;
    }

    public Long getIdIspit() {
        return idIspit;
    }

    public void setIdIspit(Long idIspit) {
        this.idIspit = idIspit;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Long getIdPredmet() {
        return idPredmet;
    }

    public void setIdPredmet(Long idPredmet) {
        this.idPredmet = idPredmet;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getVrsta() {
        return vrsta;
    }

    public void setVrsta(String vrsta) {
        this.vrsta = vrsta;
    }
}
