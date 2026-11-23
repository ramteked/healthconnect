package com.healthconnect.patient;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDate;
import java.util.UUID;

public interface PatientRepository extends JpaRepository<Patient, UUID> {
    @Query("""
        select p from Patient p
        where p.organizationId = :organizationId
          and (:mrn is null or lower(p.mrn) = lower(:mrn))
          and (:givenName is null or lower(p.givenName) like lower(concat('%', :givenName, '%')))
          and (:familyName is null or lower(p.familyName) like lower(concat('%', :familyName, '%')))
          and (:dateOfBirth is null or p.dateOfBirth = :dateOfBirth)
        """)
    Page<Patient> search(@Param("organizationId") UUID organizationId,
        @Param("mrn") String mrn, @Param("givenName") String givenName,
        @Param("familyName") String familyName, @Param("dateOfBirth") LocalDate dateOfBirth,
        Pageable pageable);
}
