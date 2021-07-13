package ftn.uns.ac.rs.eobrazovanje.model;

import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Table(name = "pohadjanja")
@Where(clause = "obrisan = false")
public class PohadjanjePredmeta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "izvedba_id", referencedColumnName = "id")
    private IzvedbaPredmeta izvedba;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;

    @Column(name = "obrisan")
    private boolean obrisan;

    public PohadjanjePredmeta() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public IzvedbaPredmeta getIzvedba() {
        return izvedba;
    }

    public void setIzvedba(IzvedbaPredmeta izvedba) {
        this.izvedba = izvedba;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public boolean isObrisan() {
        return obrisan;
    }

    public void setObrisan(boolean obrisan) {
        this.obrisan = obrisan;
    }

    @Override
    public String toString() {
        return "PohadjanjePredmeta{" +
                "id=" + id +
                ", izvedba=" + izvedba +
                ", student=" + student +
                ", obrisan=" + obrisan +
                '}';
    }
}
