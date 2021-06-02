package com.example.tseo.repository;
import com.example.tseo.model.UplataStudenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface UplataStudentaRepository extends JpaRepository<UplataStudenta, Long> {

}
