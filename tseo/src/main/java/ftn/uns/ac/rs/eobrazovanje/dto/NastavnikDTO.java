package ftn.uns.ac.rs.eobrazovanje.dto;

import ftn.uns.ac.rs.eobrazovanje.model.Nastavnik;

public class NastavnikDTO {

    private Long id;
    private String ime;
    private String prezime;
    private String jmbg;
    private String mestoStanovanja;
    private boolean obrisan = false;
    private KorisnikDTO korisnik;
//    private KorisnickiNalogDTOZaNastavnika nalog;
//    private List<PredavanjePredmetaDTOZaNastavnika> predaje;


    public NastavnikDTO() {
    }

    public NastavnikDTO(Long id, String ime, String prezime, String jmbg, String mestoStanovanja, boolean obrisan, KorisnikDTO korisnik) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.jmbg = jmbg;
        this.mestoStanovanja = mestoStanovanja;
        this.obrisan = obrisan;
        this.korisnik = korisnik;
    }

    public NastavnikDTO(Long id, String ime, String prezime, String jmbg, String mestoStanovanja, boolean obrisan) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.jmbg = jmbg;
        this.mestoStanovanja = mestoStanovanja;
        this.obrisan = obrisan;
    }

    public NastavnikDTO(Nastavnik nastavnik) {
        this(nastavnik.getId(), nastavnik.getIme(), nastavnik.getPrezime(), nastavnik.getJmbg(), nastavnik.getMestoStanovanja(), nastavnik.isObrisan());
    }
    
    public NastavnikDTO(Nastavnik nastavnik, KorisnikDTO korisnik) {
        this(nastavnik.getId(), nastavnik.getIme(), nastavnik.getPrezime(), nastavnik.getJmbg(), nastavnik.getMestoStanovanja(), nastavnik.isObrisan(), korisnik);
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

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getMestoStanovanja() {
        return mestoStanovanja;
    }

    public void setMestoStanovanja(String mestoStanovanja) {
        this.mestoStanovanja = mestoStanovanja;
    }

    public boolean isObrisan() {
        return obrisan;
    }

    public void setObrisan(boolean obrisan) {
        this.obrisan = obrisan;
    }

	public KorisnikDTO getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(KorisnikDTO korisnik) {
		this.korisnik = korisnik;
	}
    
    
}
