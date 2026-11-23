package com.healthconnect.patient;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

public record PatientResponse(UUID id, String mrn, String givenName, String familyName,
    LocalDate dateOfBirth, String administrativeGender, String phone, String email,
    boolean active, long version, Instant createdAt) {
    static PatientResponse from(Patient p) {
        return new PatientResponse(p.getId(), p.getMrn(), p.getGivenName(), p.getFamilyName(),
            p.getDateOfBirth(), p.getAdministrativeGender(), p.getPhone(), p.getEmail(),
            p.isActive(), p.getVersion(), p.getCreatedAt());
    }
}
