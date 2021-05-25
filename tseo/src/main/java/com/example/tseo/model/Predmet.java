package com.example.tseo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Predmet {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String naziv;
    private Integer espb;

    @Column(name = "sifra_predmeta")
    private String sifraPredmeta;
    private Integer godina;
    private Smer smer;

    @JsonIgnore
    @OneToMany(mappedBy = "predmet", cascade = CascadeType.ALL)
    private List<Ispit> ispiti;

    @JsonIgnore
    @OneToMany(mappedBy = "predmet")
    private List<IzvedbaPredmeta> izvedbe;

    public Predmet() {
    }

    public Predmet(Long id, String naziv, Integer espb, String sifraPredmeta, Integer godina, Smer smer, List<Ispit> ispiti, List<IzvedbaPredmeta> izvedbe) {
        this.id = id;
        this.naziv = naziv;
        this.espb = espb;
        this.sifraPredmeta = sifraPredmeta;
        this.godina = godina;
        this.smer = smer;
        this.ispiti = ispiti;
        this.izvedbe = izvedbe;
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

    public Integer getGodina() {
        return godina;
    }

    public void setGodina(Integer godina) {
        this.godina = godina;
    }

    public Smer getSmer() {
        return smer;
    }

    public void setSmer(Smer smer) {
        this.smer = smer;
    }

    public List<Ispit> getIspiti() {
        return ispiti;
    }

    public void setIspiti(List<Ispit> ispiti) {
        this.ispiti = ispiti;
    }

    public List<IzvedbaPredmeta> getIzvedbe() {
        return izvedbe;
    }

    public void setIzvedbe(List<IzvedbaPredmeta> izvedbe) {
        this.izvedbe = izvedbe;
    }

    @Override
    public String toString() {
        return "Predmet{" +
                "id=" + id +
                ", naziv='" + naziv + '\'' +
                ", espb=" + espb +
                ", sifraPredmeta='" + sifraPredmeta + '\'' +
                ", godina=" + godina +
                ", smer=" + smer +
                ", ispiti=" + ispiti +
                ", izvedbe=" + izvedbe +
                '}';
    }
}
