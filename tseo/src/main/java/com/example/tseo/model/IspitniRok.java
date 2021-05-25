package com.example.tseo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "ispitni_rokovi")
public class IspitniRok implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String naziv;

    @Column(name = "datum_pocetka")
    private Date datumPocetka;

    @Column(name = "datum_zavrsetka")
    private Date datumZavrsetka;

    public IspitniRok() {
    }

    public IspitniRok(Long id, String naziv, Date datumPocetka, Date datumZavrsetka) {
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

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
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

    @Override
    public String toString() {
        return "IspitniRok{" +
                "id=" + id +
                ", naziv='" + naziv + '\'' +
                ", datumPocetka=" + datumPocetka +
                ", datumZavrsetka=" + datumZavrsetka +
                '}';
    }
}
