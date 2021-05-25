package com.example.tseo.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "izlasci")
public class IzlazakNaIspit implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer bodovi;
    private Boolean polozio;
    private Integer ocena;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "ispit_id", referencedColumnName = "id")
    private Ispit ispit;

    public IzlazakNaIspit() {
    }

    public IzlazakNaIspit(Long id, Integer bodovi, Boolean polozio, Integer ocena, Student student, Ispit ispit) {
        this.id = id;
        this.bodovi = bodovi;
        this.polozio = polozio;
        this.ocena = ocena;
        this.student = student;
        this.ispit = ispit;
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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Ispit getIspit() {
        return ispit;
    }

    public void setIspit(Ispit ispit) {
        this.ispit = ispit;
    }

    @Override
    public String toString() {
        return "IzlazakNaIspit{" +
                "id=" + id +
                ", bodovi=" + bodovi +
                ", polozio=" + polozio +
                ", ocena=" + ocena +
                ", student=" + student +
                ", ispit=" + ispit +
                '}';
    }
}
