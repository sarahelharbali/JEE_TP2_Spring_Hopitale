package ma.enset.tppatient.tp2_part1springdata.Repository;

import jakarta.transaction.Transactional;
import ma.enset.tppatient.tp2_part1springdata.Entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    List<Patient> findByNomContains(String mc);
    @Modifying
    @Transactional
    @Query("update Patient p set p.nom=:nom, p.malade=:malade WHERE p.id=:id")
    void updatePatient(@Param("id") Long id, @Param("nom") String nom, @Param("malade") boolean malade);
}
