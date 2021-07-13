package ftn.uns.ac.rs.eobrazovanje.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "studenti")
public class Student implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ime")
    private String ime;

    @Column(name = "prezime")
    private String prezime;

    @Column(name = "jmbg")
    private String JMBG;

    @Column(name = "mesto")
    private String mestoStanovanja;

    @Column(name = "smer")
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

    public Student(){

    }

    public Student(String ime, String prezime, String JMBG, String mestoStanovanja, String smer, String brIndeksa) {
        this.ime = ime;
        this.prezime = prezime;
        this.JMBG = JMBG;
        this.mestoStanovanja = mestoStanovanja;
        this.smer = smer;
        this.brIndeksa = brIndeksa;
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
                '}';
    }
}
