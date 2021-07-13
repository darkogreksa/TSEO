package ftn.uns.ac.rs.eobrazovanje.repository;

import ftn.uns.ac.rs.eobrazovanje.model.UplataStudenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

    import java.util.Date;
    import java.util.List;

public interface UplataStudentaRepository extends JpaRepository<UplataStudenta, Long> {

    @Query(value = "select u from UplataStudenta u where datum between :startDate and :endDate")
    public List<UplataStudenta> getAllBetweenDates(@Param("startDate")Date startDate, @Param("endDate") Date endDate);

//   public List<UplataStudenta> findByDatumAfterAndDatumBefore(Date startDate, Date endDate)

    List<UplataStudenta> findAllByStudentId(Long id);
}
