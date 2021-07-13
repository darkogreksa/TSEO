package ftn.uns.ac.rs.eobrazovanje.model;

import javax.persistence.*;

@Entity
@Table(name = "dokument")
public class DokumentStudent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "naziv")
    private String naziv;

    @Column
    private String tip;

    @Lob
    private byte[] data;

    @ManyToOne()
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;

    public DokumentStudent(){

    }

    public DokumentStudent(String naziv, String tip, byte[] data, Student student) {
        this.naziv = naziv;
        this.tip = tip;
        this.data = data;
        this.student = student;
    }

    public DokumentStudent(String naziv, String fileDownloadUri, String contentType, long size) {
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

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
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
                '}';
    }
}
