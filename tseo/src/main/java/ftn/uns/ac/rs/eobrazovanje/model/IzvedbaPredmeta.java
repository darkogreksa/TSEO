package ftn.uns.ac.rs.eobrazovanje.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity()
@Table(name = "izvedbe")
@Where(clause = "obrisan = false")
public class IzvedbaPredmeta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "pocetak")
    private Date pocetak;

    @Temporal(TemporalType.DATE)
    @Column(name = "kraj")
    private Date kraj;

    @ManyToOne
    @JoinColumn(name = "predmet_id", referencedColumnName = "id")
    private Predmet predmet;

    @JsonIgnore
    @OneToMany(mappedBy = "izvedba")
    private Set<PredavanjePredmeta> predavanja = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "izvedba")
    private Set<PohadjanjePredmeta> pohadjanja = new HashSet<>();

    @Column(name = "obrisan")
    private boolean obrisan;

    public IzvedbaPredmeta() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getPocetak() {
        return pocetak;
    }

    public void setPocetak(Date pocetak) {
        this.pocetak = pocetak;
    }

    public Date getKraj() {
        return kraj;
    }

    public void setKraj(Date kraj) {
        this.kraj = kraj;
    }

    public Predmet getPredmet() {
        return predmet;
    }

    public void setPredmet(Predmet predmet) {
        this.predmet = predmet;
    }

    public Set<PredavanjePredmeta> getPredavanja() {
        return predavanja;
    }

    public void setPredavanja(Set<PredavanjePredmeta> predavanja) {
        this.predavanja = predavanja;
    }

    public Set<PohadjanjePredmeta> getPohadjanja() {
        return pohadjanja;
    }

    public void setPohadjanja(Set<PohadjanjePredmeta> pohadjanja) {
        this.pohadjanja = pohadjanja;
    }

    public boolean isObrisan() {
        return obrisan;
    }

    public void setObrisan(boolean obrisan) {
        this.obrisan = obrisan;
    }

    @Override
    public String toString() {
        return "IzvedbaPredmeta{" +
                "id=" + id +
                ", pocetak=" + pocetak +
                ", kraj=" + kraj +
                ", predmet=" + predmet +
                ", obrisan=" + obrisan +
                '}';
    }
}
