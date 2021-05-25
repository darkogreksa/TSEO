package com.example.tseo.model;

import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "nastavnici")
@Where(clause = "obrisan='false'")
public class Nastavnik {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ime;
    private String prezime;

    @Column(name = "jmbg", length = 13)
    private String jmbg;

    @Column(name = "mesto")
    private String mestoStanovanja;

    @Column(name = "obrisan")
    private boolean obrisan;

    @OneToOne
    @JoinColumn(name = "korisnik", referencedColumnName = "id")
    private Korisnik korisnik;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "nastavnik")
    private List<PredavanjePredmeta> predaje;

    public Nastavnik() {
    }

    public Nastavnik(Long id, String ime, String prezime, String jmbg, String mestoStanovanja, boolean obrisan, Korisnik korisnik, List<PredavanjePredmeta> predaje) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.jmbg = jmbg;
        this.mestoStanovanja = mestoStanovanja;
        this.obrisan = obrisan;
        this.korisnik = korisnik;
        this.predaje = predaje;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getMestoStanovanja() {
        return mestoStanovanja;
    }

    public void setMestoStanovanja(String mestoStanovanja) {
        this.mestoStanovanja = mestoStanovanja;
    }

    public boolean isObrisan() {
        return obrisan;
    }

    public void setObrisan(boolean obrisan) {
        this.obrisan = obrisan;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public List<PredavanjePredmeta> getPredaje() {
        return predaje;
    }

    public void setPredaje(List<PredavanjePredmeta> predaje) {
        this.predaje = predaje;
    }

    @Override
    public String toString() {
        return "Nastavnik{" +
                "id=" + id +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", jmbg='" + jmbg + '\'' +
                ", mestoStanovanja='" + mestoStanovanja + '\'' +
                ", obrisan=" + obrisan +
                ", korisnik=" + korisnik +
                ", predaje=" + predaje +
                '}';
    }
}
