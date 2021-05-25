package com.example.tseo.model;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "dokument")
public class DokumentStudent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String naziv;
    private String tip;

    @ManyToOne()
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;

    public DokumentStudent() {
    }

    public DokumentStudent(Long id, String naziv, String tip, Student student) {
        this.id = id;
        this.naziv = naziv;
        this.tip = tip;
        this.student = student;
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

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "DokumentStudent{" +
                "id=" + id +
                ", naziv='" + naziv + '\'' +
                ", tip='" + tip + '\'' +
                ", student=" + student +
                '}';
    }
}
