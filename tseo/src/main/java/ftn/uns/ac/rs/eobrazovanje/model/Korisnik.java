package ftn.uns.ac.rs.eobrazovanje.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "korisnici")
public class Korisnik implements Serializable, UserDetails {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "korisnicko_ime")
	private String korisnickoIme;
	
	@Column(name = "lozinka")
	private String lozinka;
	
	@Column(name = "datum")
	private Date datumKreiranja;
	
//	@Column(name = "uloga")
//	private String uloga;
	
//	@ManyToOne
//	@JoinColumn(name="authority_id", referencedColumnName="id")
//	private Authority authority;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_authority", joinColumns = @JoinColumn(name="user_id", referencedColumnName="id"),
			inverseJoinColumns = @JoinColumn(name="authority_id", referencedColumnName="id"))
	private Set<Authority> user_authorities = new HashSet<>();
	
	@OneToOne(mappedBy = "korisnik")
    private Student student;
	
	@OneToOne(mappedBy = "korisnik")
    private Nastavnik nastavnik;
	
	public Korisnik() {
		
	}
	
	

	public Korisnik(Long id, String korisnickoIme, String lozinka, Date datumKreiranja, Student student, Nastavnik nastavnik) {
		super();
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

//	public String getUloga() {
//		return uloga;
//	}
//
//	public void setUloga(String uloga) {
//		this.uloga = uloga;
//	}
	
//	public Authority getAuthority() {
//		return authority;
//	}
//
//	public void setAuthority(Authority authority) {
//		this.authority = authority;
//	}
	
	

	public Student getStudent() {
		return student;
	}

	public void setUser_authorities(Set<Authority> user_authorities) {
		this.user_authorities = user_authorities;
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
		return "Korisnik [id=" + id + ", korisnickoIme=" + korisnickoIme + ", lozinka=" + lozinka + ", datumKreiranja="
				+ datumKreiranja + ",  + ]";
	}
	
	
	
	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return user_authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return lozinka;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return korisnickoIme;
	}
	
	
	
	
	

}
