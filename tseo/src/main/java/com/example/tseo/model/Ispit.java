package com.example.tseo.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ispit")
public class Ispit {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String vrsta;
    private Date datum;
    private String ucionica;

    @ManyToOne()
    @JoinColumn(name = "predmet_id", referencedColumnName = "id")
    private Predmet predmet;

    @ManyToOne()
    @JoinColumn(name = "rok_id", referencedColumnName = "id")
    private IspitniRok rok;

    @OneToMany(mappedBy = "ispit")
    private List<IzlazakNaIspit> izlasci;

    public Ispit() {
    }

    public Ispit(Long id, String vrsta, Date datum, String ucionica, Predmet predmet, IspitniRok rok, List<IzlazakNaIspit> izlasci) {
        this.id = id;
        this.vrsta = vrsta;
        this.datum = datum;
        this.ucionica = ucionica;
        this.predmet = predmet;
        this.rok = rok;
        this.izlasci = izlasci;
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

    public void setPredmet(Predmet predmet) {
        this.predmet = predmet;
    }

    public IspitniRok getRok() {
        return rok;
    }

    public void setRok(IspitniRok rok) {
        this.rok = rok;
    }

    public List<IzlazakNaIspit> getIzlasci() {
        return izlasci;
    }

    public void setIzlasci(List<IzlazakNaIspit> izlasci) {
        this.izlasci = izlasci;
    }
}
