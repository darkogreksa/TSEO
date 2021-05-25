package com.example.tseo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "korisnici")
public class Korisnik implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "korisnicko_ime")
    private String korisnickoIme;
    private String lozinka;

    @Column(name = "datum")
    private Date datumKreiranja;

//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "user_authority", joinColumns = @JoinColumn(name="user_id", referencedColumnName="id"),
//            inverseJoinColumns = @JoinColumn(name="authority_id", referencedColumnName="id"))
//    private Set<Authority> user_authorities = new HashSet<>();

    @OneToOne(mappedBy = "korisnik")
    private Student student;

    @OneToOne(mappedBy = "korisnik")
    private Nastavnik nastavnik;

    public Korisnik() {
    }

    public Korisnik(Long id, String korisnickoIme, String lozinka, Date datumKreiranja, Student student, Nastavnik nastavnik) {
        this.id = id;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        this.datumKreiranja = datumKreiranja;
        this.student = student;
        this.nastavnik = nastavnik;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public Date getDatumKreiranja() {
        return datumKreiranja;
    }

    public void setDatumKreiranja(Date datumKreiranja) {
        this.datumKreiranja = datumKreiranja;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Nastavnik getNastavnik() {
        return nastavnik;
    }

    public void setNastavnik(Nastavnik nastavnik) {
        this.nastavnik = nastavnik;
    }

    @Override
    public String toString() {
        return "Korisnik{" +
                "id=" + id +
                ", korisnickoIme='" + korisnickoIme + '\'' +
                ", lozinka='" + lozinka + '\'' +
                ", datumKreiranja=" + datumKreiranja +
                ", student=" + student +
                ", nastavnik=" + nastavnik +
                '}';
    }
}
