package ftn.uns.ac.rs.eobrazovanje.dto;

import ftn.uns.ac.rs.eobrazovanje.model.Korisnik;
import ftn.uns.ac.rs.eobrazovanje.model.Student;

//JSON include non null GUGLATI
public class StudentDTO {

    private Long id;
    private String ime;
    private String prezime;
    private String JMBG;
    private String mestoStanovanja;
    private String smer;
    private String brIndeksa;
    private KorisnikDTO korisnik;

    public StudentDTO() {
    }

    public StudentDTO(Long id, String ime, String prezime, String JMBG, String mestoStanovanja, String smer, String brIndeksa, KorisnikDTO korisnik) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.JMBG = JMBG;
        this.mestoStanovanja = mestoStanovanja;
        this.smer = smer;
        this.brIndeksa = brIndeksa;
        this.korisnik = korisnik;
    }
    
    public StudentDTO(Long id, String ime, String prezime, String JMBG, String mestoStanovanja, String smer, String brIndeksa) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.JMBG = JMBG;
        this.mestoStanovanja = mestoStanovanja;
        this.smer = smer;
        this.brIndeksa = brIndeksa;
    }

    public StudentDTO(Student student, KorisnikDTO korisnik){
        this(student.getId(), student.getIme(), student.getPrezime(), student.getJMBG(), student.getMestoStanovanja(), student.getSmer(), student.getBrIndeksa(), korisnik);
    }
    
    public StudentDTO(Student student){
        this(student.getId(), student.getIme(), student.getPrezime(), student.getJMBG(), student.getMestoStanovanja(), student.getSmer(), student.getBrIndeksa());
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
    
    

    public KorisnikDTO getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(KorisnikDTO korisnik) {
		this.korisnik = korisnik;
	}

	@Override
    public String toString() {
        return "StudentDTO{" +
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
