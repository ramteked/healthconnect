package com.healthconnect.patient;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.time.LocalDate;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/patients")
public class PatientController {
    private final PatientService service;
    public PatientController(PatientService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<PatientResponse> register(@Valid @RequestBody CreatePatientRequest request) {
        PatientResponse response = service.register(request);
        return ResponseEntity.created(URI.create("/api/v1/patients/" + response.id())).body(response);
    }

    @GetMapping("/{id}")
    public PatientResponse get(@PathVariable UUID id) { return service.get(id); }

    @GetMapping
    public Page<PatientResponse> search(
        @RequestParam(required = false) String mrn,
        @RequestParam(required = false) String givenName,
        @RequestParam(required = false) String familyName,
        @RequestParam(required = false)
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateOfBirth,
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "20") int size) {
        if (page < 0 || size < 1 || size > 100) {
            throw new org.springframework.web.server.ResponseStatusException(
                org.springframework.http.HttpStatus.BAD_REQUEST, "Invalid page or size");
        }
        return service.search(mrn, givenName, familyName, dateOfBirth,
            PageRequest.of(page, size, Sort.by("familyName").ascending().and(Sort.by("givenName"))));
    }

    @PostMapping("/{id}/deactivate")
    public ResponseEntity<Void> deactivate(@PathVariable UUID id) {
        service.deactivate(id);
        return ResponseEntity.noContent().build();
    }
}
