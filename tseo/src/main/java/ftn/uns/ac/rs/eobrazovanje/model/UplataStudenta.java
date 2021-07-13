package ftn.uns.ac.rs.eobrazovanje.model;

import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "uplate")
@Where(clause = "obrisan='false'")
public class UplataStudenta {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "iznos")
    private BigDecimal iznos;

    @Temporal(TemporalType.DATE)
    @Column(name = "datum")
    private Date datum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "studentId", referencedColumnName = "id")
    private Student student;

    @Column(name = "obrisan")
    private boolean obrisan;

    public UplataStudenta() {
    }

    public UplataStudenta(BigDecimal iznos, Date datum, Student student, boolean obrisan) {
        this.iznos = iznos;
        this.datum = datum;
        this.student = student;
        this.obrisan = obrisan;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getIznos() {
        return iznos;
    }

    public void setIznos(BigDecimal iznos) {
        this.iznos = iznos;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
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
        return "UplataStudenta{" +
                "id=" + id +
                ", iznos=" + iznos +
                ", datum=" + datum +
                ", student=" + student +
                ", obrisan=" + obrisan +
                '}';
    }
}
