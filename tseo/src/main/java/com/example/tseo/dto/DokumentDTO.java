package com.example.tseo.dto;

import com.example.tseo.model.DokumentStudent;

public class DokumentDTO {

    private Long id;
    private String naziv;

    public DokumentDTO(){

    }

    public DokumentDTO(Long id, String naziv) {
        this.id = id;
        this.naziv = naziv;
    }

    public DokumentDTO(DokumentStudent dokumentStudent){
        this(dokumentStudent.getId(), dokumentStudent.getNaziv());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
}
