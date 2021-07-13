package ftn.uns.ac.rs.eobrazovanje.servis;

import ftn.uns.ac.rs.eobrazovanje.model.IzvedbaPredmeta;
import ftn.uns.ac.rs.eobrazovanje.model.Nastavnik;
import ftn.uns.ac.rs.eobrazovanje.model.PredavanjePredmeta;
import ftn.uns.ac.rs.eobrazovanje.repository.PredavanjePredmetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PredavanjePredmetaService {

    @Autowired
    private PredavanjePredmetaRepository predavanjeRepo;

    public List<PredavanjePredmeta> findAll() {
        return predavanjeRepo.findAll();
    }

    public PredavanjePredmeta getOne(Long id) {
        return predavanjeRepo.getOne(id);
    }

    public PredavanjePredmeta create(PredavanjePredmeta predavanje) {
        return predavanjeRepo.save(predavanje);
    }

    public PredavanjePredmeta update(PredavanjePredmeta predavanje) {
        return predavanjeRepo.save(predavanje);
    }

    public void deleteLogically(PredavanjePredmeta predavanje) {
        predavanje.setObrisan(true);
        //logika za kaskadno brisanje ovde...
        predavanjeRepo.save(predavanje);
    }

    public void deleteById(Long id) {
        predavanjeRepo.deleteById(id);
    }

    public void delete(PredavanjePredmeta predavanje) {
        predavanjeRepo.delete(predavanje);
    }

    public List<PredavanjePredmeta> getAllByNastavnik(Nastavnik nastavnik) {
        return predavanjeRepo.getAllByNastavnik(nastavnik);
    }

    public List<PredavanjePredmeta> getAllByNastavnik_Id(Long nastavnikId) {
        return predavanjeRepo.getAllByNastavnik_Id(nastavnikId);
    }

    public List<PredavanjePredmeta> getAllByIzvedba(IzvedbaPredmeta izvedba) {
        return predavanjeRepo.getAllByIzvedba(izvedba);
    }

    public List<PredavanjePredmeta> getAllByizvedba_Id(Long izvedbaId) {
        return predavanjeRepo.getAllByIzvedba_Id(izvedbaId);
    }


}
