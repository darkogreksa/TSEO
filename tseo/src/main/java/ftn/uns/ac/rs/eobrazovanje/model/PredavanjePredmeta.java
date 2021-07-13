package ftn.uns.ac.rs.eobrazovanje.model;

import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Table(name = "predavanja")
@Where(clause = "obrisan=false")
public class PredavanjePredmeta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "nastavnik_id", referencedColumnName = "id")
    private Nastavnik nastavnik;

    @ManyToOne()
    @JoinColumn(name = "izvedba_id", referencedColumnName = "id")
    private IzvedbaPredmeta izvedba;

    @Column(name = "obrisan")
    private boolean obrisan;

    public PredavanjePredmeta() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Nastavnik getNastavnik() {
        return nastavnik;
    }

    public void setNastavnik(Nastavnik nastavnik) {
        this.nastavnik = nastavnik;
    }

    public IzvedbaPredmeta getIzvedba() {
        return izvedba;
    }

    public void setIzvedba(IzvedbaPredmeta izvedba) {
        this.izvedba = izvedba;
    }

    public boolean isObrisan() {
        return obrisan;
    }

    public void setObrisan(boolean obrisan) {
        this.obrisan = obrisan;
    }

    @Override
    public String toString() {
        return "PredavanjePredmeta{" +
                "id=" + id +
                ", nastavnik=" + nastavnik +
                ", izvedba=" + izvedba +
                ", obrisan=" + obrisan +
                '}';
    }
}
