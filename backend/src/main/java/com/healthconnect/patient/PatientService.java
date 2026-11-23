package com.healthconnect.patient;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import java.time.LocalDate;
import java.util.UUID;

@Service
@Transactional
public class PatientService {
    // Single demo organization. Replace with authenticated organization context before multi-org use.
    private static final UUID DEMO_ORGANIZATION_ID =
        UUID.fromString("11111111-1111-1111-1111-111111111111");
    private final PatientRepository repository;

    public PatientService(PatientRepository repository) { this.repository = repository; }

    public PatientResponse register(CreatePatientRequest request) {
        String mrn = "HC-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        Patient patient = new Patient(DEMO_ORGANIZATION_ID, mrn, request.givenName().trim(),
            request.familyName().trim(), request.dateOfBirth(),
            request.administrativeGender() == null ? null : request.administrativeGender().toLowerCase(),
            request.phone(), request.email());
        return PatientResponse.from(repository.save(patient));
    }

    @Transactional(readOnly = true)
    public PatientResponse get(UUID id) {
        Patient patient = repository.findById(id)
            .filter(p -> p.getOrganizationId().equals(DEMO_ORGANIZATION_ID))
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Patient not found"));
        return PatientResponse.from(patient);
    }

    @Transactional(readOnly = true)
    public Page<PatientResponse> search(String mrn, String givenName, String familyName,
        LocalDate dateOfBirth, Pageable pageable) {
        if (blank(mrn) && blank(givenName) && blank(familyName) && dateOfBirth == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                "Provide at least one search criterion");
        }
        return repository.search(DEMO_ORGANIZATION_ID, clean(mrn), clean(givenName),
            clean(familyName), dateOfBirth, pageable).map(PatientResponse::from);
    }

    public void deactivate(UUID id) {
        Patient patient = repository.findById(id)
            .filter(p -> p.getOrganizationId().equals(DEMO_ORGANIZATION_ID))
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Patient not found"));
        patient.deactivate();
    }

    private static String clean(String s) { return blank(s) ? null : s.trim(); }
    private static boolean blank(String s) { return s == null || s.isBlank(); }
}
