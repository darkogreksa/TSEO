package ftn.uns.ac.rs.eobrazovanje.servis;

import ftn.uns.ac.rs.eobrazovanje.model.Student;
import ftn.uns.ac.rs.eobrazovanje.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService{

    @Autowired
    StudentRepository studentRepository;

    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    public Student getOne(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student create(Student s){
        return studentRepository.save(s);
    }

    public void delete(Long id){
        studentRepository.deleteById(id);
    }

    public Page<Student> findAllPaged(Integer page, Integer size) {
        PageRequest pageReq = PageRequest.of(page, size);
        Page<Student> students = studentRepository.findAll(pageReq);

        return students;
    }

    public List<Student> findAllByIme(String ime){
        List<Student> studenti = studentRepository.findAllByIme(ime);

        return studenti;
    }
}
