package com.example.tseo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "studenti")
public class Student implements Serializable {

    /**
     * The serialVersionUID is a universal version identifier for a Serializable class.
     * Deserialization uses this number to ensure that a loaded class corresponds exactly
     * to a serialized object. If no match is found, then an InvalidClassException is thrown
     */
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ime;
    private String prezime;

    @Column(name = "jmbg")
    private String JMBG;

    @Column(name = "mesto")
    private String mestoStanovanja;
    private String smer;

    @Column(name = "brIndeksa")
    private String brIndeksa;

    @OneToMany(mappedBy = "student")
    private Set<DokumentStudent> dokumentiStudenta = new HashSet<>();

    @OneToMany(mappedBy = "student")
    private Set<UplataStudenta> uplateStudenta = new HashSet<>();

    @OneToMany(mappedBy = "student")
    private Set<PohadjanjePredmeta> pohadjanjePredmeta = new HashSet<>();

    @OneToMany(mappedBy = "student")
    private Set<IzlazakNaIspit> izlasci = new HashSet<>();

    @OneToOne
    @JoinColumn(name = "korisnik", referencedColumnName = "id")
    private Korisnik korisnik;

    public Student() {
    }

    public Student(Long id, String ime, String prezime, String JMBG, String mestoStanovanja, String smer, String brIndeksa, Set<DokumentStudent> dokumentiStudenta, Set<UplataStudenta> uplateStudenta, Set<PohadjanjePredmeta> pohadjanjePredmeta, Set<IzlazakNaIspit> izlasci, Korisnik korisnik) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.JMBG = JMBG;
        this.mestoStanovanja = mestoStanovanja;
        this.smer = smer;
        this.brIndeksa = brIndeksa;
        this.dokumentiStudenta = dokumentiStudenta;
        this.uplateStudenta = uplateStudenta;
        this.pohadjanjePredmeta = pohadjanjePredmeta;
        this.izlasci = izlasci;
        this.korisnik = korisnik;
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

    public String getJMBG() {
        return JMBG;
    }

    public void setJMBG(String JMBG) {
        this.JMBG = JMBG;
    }

    public String getMestoStanovanja() {
        return mestoStanovanja;
    }

    public void setMestoStanovanja(String mestoStanovanja) {
        this.mestoStanovanja = mestoStanovanja;
    }

    public String getSmer() {
        return smer;
    }

    public void setSmer(String smer) {
        this.smer = smer;
    }

    public String getBrIndeksa() {
        return brIndeksa;
    }

    public void setBrIndeksa(String brIndeksa) {
        this.brIndeksa = brIndeksa;
    }

    public Set<DokumentStudent> getDokumentiStudenta() {
        return dokumentiStudenta;
    }

    public void setDokumentiStudenta(Set<DokumentStudent> dokumentiStudenta) {
        this.dokumentiStudenta = dokumentiStudenta;
    }

    public Set<UplataStudenta> getUplateStudenta() {
        return uplateStudenta;
    }

    public void setUplateStudenta(Set<UplataStudenta> uplateStudenta) {
        this.uplateStudenta = uplateStudenta;
    }

    public Set<PohadjanjePredmeta> getPohadjanjePredmeta() {
        return pohadjanjePredmeta;
    }

    public void setPohadjanjePredmeta(Set<PohadjanjePredmeta> pohadjanjePredmeta) {
        this.pohadjanjePredmeta = pohadjanjePredmeta;
    }

    public Set<IzlazakNaIspit> getIzlasci() {
        return izlasci;
    }

    public void setIzlasci(Set<IzlazakNaIspit> izlasci) {
        this.izlasci = izlasci;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", JMBG='" + JMBG + '\'' +
                ", mestoStanovanja='" + mestoStanovanja + '\'' +
                ", smer='" + smer + '\'' +
                ", brIndeksa='" + brIndeksa + '\'' +
                ", dokumentiStudenta=" + dokumentiStudenta +
                ", uplateStudenta=" + uplateStudenta +
                ", pohadjanjePredmeta=" + pohadjanjePredmeta +
                ", izlasci=" + izlasci +
                ", korisnik=" + korisnik +
                '}';
    }
}
