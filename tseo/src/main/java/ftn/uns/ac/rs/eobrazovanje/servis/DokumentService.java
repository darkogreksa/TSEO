package ftn.uns.ac.rs.eobrazovanje.servis;

import ftn.uns.ac.rs.eobrazovanje.model.DokumentStudent;
import ftn.uns.ac.rs.eobrazovanje.model.Student;
import ftn.uns.ac.rs.eobrazovanje.repository.DokumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class DokumentService {

    @Autowired
    private DokumentRepository dokumentRepository;

    @Autowired
    private StudentService studentService;

    public List<DokumentStudent> getAll(){
        return dokumentRepository.findAll();
    }

    public DokumentStudent getById(Long id){
        return dokumentRepository.getOne(id);
    }

    public DokumentStudent addDokument(DokumentStudent dokumentStudent){
        return dokumentRepository.save(dokumentStudent);
    }

    public DokumentStudent updateDokument(Long id, DokumentStudent dokumentStudent){
        return dokumentRepository.save(dokumentStudent);
    }

    public void deleteDokument(Long id){
        dokumentRepository.deleteById(id);
    }

    public DokumentStudent storeFile(MultipartFile file, Long id) throws IOException {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Student student = studentService.getOne(id);


        DokumentStudent dbFile = new DokumentStudent(fileName, file.getContentType(), file.getBytes(), student);

        System.out.println("DOKUMEEEEEEENT " + dbFile + file.getBytes());

        return dokumentRepository.save(dbFile);
    }

    public Optional<DokumentStudent> getFile(Long fileId) {
        return dokumentRepository.findById(fileId);
    }

    public List<DokumentStudent> getByStudent(Long id){
        return dokumentRepository.findAllByStudentId(id);
    }

    public DokumentStudent findByName(String name){
        return dokumentRepository.findAllByNaziv(name);
    }
}
