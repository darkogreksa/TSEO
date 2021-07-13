package ftn.uns.ac.rs.eobrazovanje.controller;

import ftn.uns.ac.rs.eobrazovanje.dto.DokumentDTO;
import ftn.uns.ac.rs.eobrazovanje.model.DokumentStudent;
import ftn.uns.ac.rs.eobrazovanje.model.Student;
import ftn.uns.ac.rs.eobrazovanje.model.UploadFileResponse;
import ftn.uns.ac.rs.eobrazovanje.servis.DokumentService;
import ftn.uns.ac.rs.eobrazovanje.servis.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/dokument")
@CrossOrigin(origins = "http://localhost:4200")
public class DokumentController {

    @Autowired
    private DokumentService dokumentService;

    @Autowired
    private StudentService studentService;


    @GetMapping(value = "/all")
    public ResponseEntity<List<DokumentDTO>> getAll(){
        List<DokumentStudent> dokumenti = dokumentService.getAll();
        List<DokumentDTO> dokumentDTOS = new ArrayList<>();
        for (DokumentStudent d : dokumenti){
            dokumentDTOS.add(new DokumentDTO(d));
        }

        return new ResponseEntity<List<DokumentDTO>>(dokumentDTOS, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<DokumentDTO> getById(@PathVariable("id") Long id){
        DokumentStudent dokument = dokumentService.getById(id);
        DokumentDTO dokumentDTO = new DokumentDTO(dokument);
        if(dokument == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(dokumentDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<DokumentDTO> addDokument(@RequestBody DokumentDTO dokumentDTO){
        DokumentStudent dokument = new DokumentStudent();
        dokument.setNaziv(dokumentDTO.getNaziv());

        dokument = dokumentService.addDokument(dokument);

        return new ResponseEntity<DokumentDTO>(new DokumentDTO(dokument), HttpStatus.CREATED);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<DokumentDTO> updateDokument(@RequestBody DokumentDTO dokumentDTO, @PathVariable("id") Long id){
        DokumentStudent dokument = dokumentService.getById(id);
        if(dokument == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        dokument.setNaziv(dokumentDTO.getNaziv());

        dokument = dokumentService.addDokument(dokument);

        return new ResponseEntity<DokumentDTO>(new DokumentDTO(dokument), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> deleteDokument(@PathVariable("id") Long id){
       DokumentStudent dokument = dokumentService.getById(id);
       if(dokument == null){
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }

       dokumentService.deleteDokument(id);
       return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PostMapping("/upload/{id}")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file, @PathVariable("id") Long id) throws IOException {
        DokumentStudent dbFile = dokumentService.storeFile(file, id);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(String.valueOf(dbFile.getId()))
                .toUriString();

        return new UploadFileResponse(dbFile.getNaziv(), fileDownloadUri,
                file.getContentType(), file.getSize());
    }


    @GetMapping("/student/{id}")
    public ResponseEntity<List<DokumentStudent>> get(@PathVariable("id") Long id){
        List<DokumentStudent> dokumentStudent = dokumentService.getByStudent(id);

        return new ResponseEntity<>(dokumentStudent, HttpStatus.OK);
    }

    @GetMapping("/download/{name}")
    public ResponseEntity<byte[]> getFile(@PathVariable String name) {
        DokumentStudent fileOptional = dokumentService.findByName(name);

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileOptional.getNaziv() + "\"")
                    .body(fileOptional.getData());

    }
}
