package ftn.uns.ac.rs.eobrazovanje.dto;

import ftn.uns.ac.rs.eobrazovanje.model.IzlazakNaIspit;

public class IzlazakPolozioDTO {
    private Long id;
    private Integer bodovi;
    private Boolean polozio;
    private Integer ocena;
    private String nazivPredmeta;
    private Integer espb;
    private String sifra;

    public IzlazakPolozioDTO() {

    }

    public IzlazakPolozioDTO(Long id, Integer bodovi, Boolean polozio, Integer ocena, String nazivPredmeta, Integer espb, String sifra) {
        super();
        this.id = id;
        this.bodovi = bodovi;
        this.polozio = polozio;
        this.ocena = ocena;
        this.nazivPredmeta = nazivPredmeta;
        this.espb = espb;
        this.sifra = sifra;
    }

    public IzlazakPolozioDTO(IzlazakNaIspit i) {
        this(i.getId(), i.getBodovi(), i.getPolozio(), i.getOcena(), i.getIspit().getPredmet().getNaziv(), i.getIspit().getPredmet().getEspb(), i.getIspit().getPredmet().getSifraPredmeta());
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

    public String getNazivPredmeta() {
        return nazivPredmeta;
    }

    public void setNazivPredmeta(String nazivPredmeta) {
        this.nazivPredmeta = nazivPredmeta;
    }

    public Integer getEspb() {
        return espb;
    }

    public void setEspb(Integer espb) {
        this.espb = espb;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }
}
