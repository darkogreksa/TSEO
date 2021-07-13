package ftn.uns.ac.rs.eobrazovanje.dto;

import ftn.uns.ac.rs.eobrazovanje.model.Student;
import ftn.uns.ac.rs.eobrazovanje.model.UplataStudenta;

import java.math.BigDecimal;
import java.util.Date;

public class UplataStudentaDTO {
    private Long id;
    private BigDecimal iznos;
    private Date datum;
    private StudentDTO studentDTO;
    private boolean obrisan;

    public UplataStudentaDTO() {
    }

    public UplataStudentaDTO(Long id, BigDecimal iznos, Date datum, StudentDTO studentDTO, boolean obrisan) {
        this.id = id;
        this.iznos = iznos;
        this.datum = datum;
        this.studentDTO = studentDTO;
        this.obrisan = obrisan;
    }

    public UplataStudentaDTO(UplataStudenta upl) {
        this(upl.getId(), upl.getIznos(), upl.getDatum(), new StudentDTO(upl.getStudent()), upl.isObrisan());
    }

    public UplataStudentaDTO(UplataStudenta upl, StudentDTO studentDTO) {
        this(upl.getId(), upl.getIznos(), upl.getDatum(), studentDTO, upl.isObrisan());
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

    public StudentDTO getStudentDTO() {
        return studentDTO;
    }

    public void setStudentDTO(StudentDTO studentDTO) {
        this.studentDTO = studentDTO;
    }

    public boolean isObrisan() {
        return obrisan;
    }

    public void setObrisan(boolean obrisan) {
        this.obrisan = obrisan;
    }

    @Override
    public String toString() {
        return "UplataStudentaDTO{" +
                "id=" + id +
                ", iznos=" + iznos +
                ", datum=" + datum +
                ", studentDTO=" + studentDTO +
                ", obrisan=" + obrisan +
                '}';
    }
}
