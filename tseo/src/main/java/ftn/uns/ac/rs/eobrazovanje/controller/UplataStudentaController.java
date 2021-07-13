package ftn.uns.ac.rs.eobrazovanje.controller;

import ftn.uns.ac.rs.eobrazovanje.dto.NastavnikDTO;
import ftn.uns.ac.rs.eobrazovanje.dto.UplataStudentaDTO;
import ftn.uns.ac.rs.eobrazovanje.model.Nastavnik;
import ftn.uns.ac.rs.eobrazovanje.model.Student;
import ftn.uns.ac.rs.eobrazovanje.model.UplataStudenta;
import ftn.uns.ac.rs.eobrazovanje.servis.StudentService;
import ftn.uns.ac.rs.eobrazovanje.servis.UplataStudentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.Year;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/api/uplata")
public class UplataStudentaController {

    @Autowired
    private UplataStudentaService uplataService;

    @Autowired
    private StudentService studentService;

    static final DateFormat dd_MM_gggg = new SimpleDateFormat("dd-MM-yyyy");

    @GetMapping(value = "/all")
    public ResponseEntity<List<UplataStudentaDTO>> getAll() {
        List<UplataStudenta> uplate = uplataService.getAll();
        List<UplataStudentaDTO> uplateDTOs = new ArrayList<>();
        for (UplataStudenta u : uplate) {
            uplateDTOs.add(new UplataStudentaDTO(u));
        }

        return new ResponseEntity<List<UplataStudentaDTO>>(uplateDTOs, HttpStatus.OK);
    }

    @GetMapping(value = "", params = {"page", "size"})
    public ResponseEntity<List<UplataStudentaDTO>> getAll(@RequestParam("page") Integer page, @RequestParam("size") Integer size ) {
        List<UplataStudenta> uplate = uplataService.getAll(page, size);
        List<UplataStudentaDTO> uplateDTOs = new ArrayList<>();
        for (UplataStudenta u : uplate) {
            uplateDTOs.add(new UplataStudentaDTO(u));
        }

        return new ResponseEntity<List<UplataStudentaDTO>>(uplateDTOs, HttpStatus.OK);
    }

    @GetMapping(value = "", params = {"startDate", "endDate"})
    public ResponseEntity<List<UplataStudentaDTO>> getBetweenDates(@RequestParam("startDate") String startDateString, @RequestParam("endDate") String endDateString) {

        Date startDate;
        Date endDate;
        try {
            startDate = dd_MM_gggg.parse(startDateString);
            endDate = dd_MM_gggg.parse(endDateString);
        } catch (ParseException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        List<UplataStudenta> uplate = uplataService.getAllBetweenDates(startDate, endDate);
        List<UplataStudentaDTO> uplateDTOs = new ArrayList<>();
        for (UplataStudenta u : uplate) {
            uplateDTOs.add(new UplataStudentaDTO(u));
        }

        return new ResponseEntity<List<UplataStudentaDTO>>(uplateDTOs, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UplataStudentaDTO> getOne(@PathVariable("id") Long id) {
        UplataStudenta uplata = uplataService.getOne(id);

        if (uplata == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        UplataStudentaDTO uplataDTO = new UplataStudentaDTO(uplata);

        return new ResponseEntity<UplataStudentaDTO>(uplataDTO, HttpStatus.OK);
    }



    @PostMapping(value = "", consumes = "application/json")
    public ResponseEntity<UplataStudentaDTO> create (@RequestBody UplataStudentaDTO uplataDTO) {
        UplataStudenta uplata = new UplataStudenta();

        uplata.setDatum(uplataDTO.getDatum());
        uplata.setIznos(uplataDTO.getIznos());
        // da li uopste ima smisla dozvoliti kreiranje obrisanog entiteta?
        uplata.setObrisan(uplataDTO.isObrisan());

        // dodeljivanje studenta uplati
        Student st = studentService.getOne(uplataDTO.getStudentDTO().getId());
        if (st != null) {
            uplata.setStudent(st);
        }

        uplata = uplataService.create(uplata);
        return new ResponseEntity<UplataStudentaDTO>(new UplataStudentaDTO(uplata), HttpStatus.CREATED);
    }

    @PutMapping(consumes = "application/json")
    public ResponseEntity<UplataStudentaDTO> update(@RequestBody UplataStudentaDTO uplataDTO) {
        UplataStudenta uplata = uplataService.getOne(uplataDTO.getId());
        if (uplata == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if (uplataDTO.isObrisan() == true) {
            uplataService.deleteLogically(uplata);
            return new ResponseEntity<UplataStudentaDTO>(new UplataStudentaDTO(uplata), HttpStatus.OK);
        }

        // izmena studenta ovde...
        Student st = studentService.getOne(uplataDTO.getStudentDTO().getId());
        if (st == null) {
            // Bolje objasniti da je unet nepostojeci student...
            return new ResponseEntity<UplataStudentaDTO>(HttpStatus.CONFLICT);
        }
        uplata.setStudent(st);
        uplata.setIznos(uplataDTO.getIznos());
        uplata.setDatum(uplataDTO.getDatum());

        uplata = uplataService.update(uplata);

        return new ResponseEntity<UplataStudentaDTO>(new UplataStudentaDTO(uplata), HttpStatus.OK);
    }

    // mogućnost dodavanja opcionih parametara bi sprečila potrebu za dve overloadovane metode...
    @PutMapping(value = "/{id}",consumes = "application/json")
    public ResponseEntity<UplataStudentaDTO> update(@PathVariable("id") Long id, @RequestBody UplataStudentaDTO uplataDTO) {
        UplataStudenta uplata = uplataService.getOne(id);
        if (uplata == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if (uplataDTO.isObrisan() == true) {
            uplataService.deleteLogically(uplata);
            return new ResponseEntity<UplataStudentaDTO>(new UplataStudentaDTO(uplata), HttpStatus.OK);
        }

        // izmena studenta ovde...
        Student st = studentService.getOne(uplataDTO.getStudentDTO().getId());
        if (st == null) {
            // Bolje objasniti da je unet nepostojeci student...
            return new ResponseEntity<UplataStudentaDTO>(HttpStatus.CONFLICT);
        }
        uplata.setStudent(st);
        uplata.setIznos(uplataDTO.getIznos());
        uplata.setDatum(uplataDTO.getDatum());

        uplata = uplataService.update(uplata);

        return new ResponseEntity<UplataStudentaDTO>(new UplataStudentaDTO(uplata), HttpStatus.OK);
    }

    @DeleteMapping(value = {"/{id}"})
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        UplataStudenta uplata = uplataService.getOne(id);
        if (uplata == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        uplataService.delete(uplata);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }


    @GetMapping(value = "/student/{id}")
    public ResponseEntity<List<UplataStudentaDTO>> getUplateStudentId(@PathVariable("id") Long id){
        List<UplataStudenta> uplate = uplataService.getByStudentId(id);
        List<UplataStudentaDTO> uplateDTO = new ArrayList<>();
        for (UplataStudenta u : uplate){
            uplateDTO.add(new UplataStudentaDTO(u));
        }

        return new ResponseEntity<List<UplataStudentaDTO>>(uplateDTO, HttpStatus.OK);
    }
}
