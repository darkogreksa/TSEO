package ftn.uns.ac.rs.eobrazovanje.servis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.uns.ac.rs.eobrazovanje.model.IzlazakNaIspit;
import ftn.uns.ac.rs.eobrazovanje.repository.IzlazakRepository;

import java.util.List;

@Service
public class IzlazakService extends CrudService<IzlazakNaIspit, IzlazakRepository, Long> {
	
	@Autowired
	IzlazakRepository izlazakRepository;

//	public List<IzlazakNaIspit> getAll(){
//		return izlazakRepository.findAll();
//	}
//	
//	public IzlazakNaIspit getOne(Long id) {
//		return izlazakRepository.findById(id).orElse(null);
//	}
//	
//	public IzlazakNaIspit save(IzlazakNaIspit i) {
//		return izlazakRepository.save(i);
//	}

    public List<IzlazakNaIspit> getAllByIspitId(Long id){
        return izlazakRepository.findAllByIspit_Id(id);
    }

    public List<IzlazakNaIspit> getAllByStudentPolozio(Long id){
        return izlazakRepository.findAllByStudentIdAndPolozioTrue(id);
    }

    public List<IzlazakNaIspit> getAllByStudentNijePolozio(Long id){
        return izlazakRepository.findAllDistinctByStudentIdAndPolozioFalse(id);
    }

}
