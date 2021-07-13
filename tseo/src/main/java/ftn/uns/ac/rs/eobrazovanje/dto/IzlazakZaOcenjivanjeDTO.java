package ftn.uns.ac.rs.eobrazovanje.dto;

import ftn.uns.ac.rs.eobrazovanje.model.IzlazakNaIspit;

public class IzlazakZaOcenjivanjeDTO {

        private Long id;
        private Integer bodovi;
        private Boolean polozio;
        private Integer ocena;
        private String ime;
        private String prezime;
        private String indeks;

        public IzlazakZaOcenjivanjeDTO() {

        }

        public IzlazakZaOcenjivanjeDTO(Long id, Integer bodovi, Boolean polozio, Integer ocena,String ime, String prezime, String indeks) {
            super();
            this.id = id;
            this.bodovi = bodovi;
            this.polozio = polozio;
            this.ocena = ocena;
            this.ime = ime;
            this.prezime = prezime;
            this.indeks = indeks;
        }

        public IzlazakZaOcenjivanjeDTO(IzlazakNaIspit i) {
            this(i.getId(), i.getBodovi(), i.getPolozio(), i.getOcena(), i.getStudent().getIme(), i.getStudent().getPrezime(), i.getStudent().getBrIndeksa());
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

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getIndeks() {
        return indeks;
    }

    public void setIndeks(String indeks) {
        this.indeks = indeks;
    }
}
