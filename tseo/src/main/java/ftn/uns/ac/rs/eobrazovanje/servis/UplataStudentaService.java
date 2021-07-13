package ftn.uns.ac.rs.eobrazovanje.servis;

import ftn.uns.ac.rs.eobrazovanje.model.UplataStudenta;
import ftn.uns.ac.rs.eobrazovanje.repository.UplataStudentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UplataStudentaService {

    @Autowired
    private UplataStudentaRepository uplataStudentaRepository;

    public List<UplataStudenta> getAll() {
        return  uplataStudentaRepository.findAll();
    }

    public List<UplataStudenta> getAll(Integer page, Integer size) {
        PageRequest pageReq = PageRequest.of(page, size);
        Page<UplataStudenta> uplate = uplataStudentaRepository.findAll(pageReq);

        return uplate.getContent();
    }

    public UplataStudenta getOne(Long id) {
        return uplataStudentaRepository.getOne(id);
    }

    public UplataStudenta create(UplataStudenta u) {
        return uplataStudentaRepository.save(u);
    }

    public UplataStudenta update(UplataStudenta u) {
        return uplataStudentaRepository.save(u);
    }

    public void deleteLogically(UplataStudenta u) {
        u.setObrisan(true);
        uplataStudentaRepository.save(u);
    }

    public void delete(Long id) {
        uplataStudentaRepository.deleteById(id);
    }

    public void delete(UplataStudenta u) {
        uplataStudentaRepository.delete(u);
    }

    public List<UplataStudenta> getAllBetweenDates(Date startDate, Date endDate) {
        return uplataStudentaRepository.getAllBetweenDates(startDate, endDate);
    }

    public List<UplataStudenta> getByStudentId(Long id){
        return uplataStudentaRepository.findAllByStudentId(id);
    }
}
