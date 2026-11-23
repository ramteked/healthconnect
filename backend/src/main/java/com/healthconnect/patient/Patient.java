package com.healthconnect.patient;

import jakarta.persistence.*;
import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "patient", uniqueConstraints =
    @UniqueConstraint(name = "uk_patient_org_mrn", columnNames = {"organization_id", "mrn"}))
public class Patient {
    @Id private UUID id;
    @Column(name = "organization_id", nullable = false) private UUID organizationId;
    @Column(nullable = false, length = 40, updatable = false) private String mrn;
    @Column(name = "given_name", nullable = false, length = 100) private String givenName;
    @Column(name = "family_name", nullable = false, length = 100) private String familyName;
    @Column(name = "date_of_birth", nullable = false) private LocalDate dateOfBirth;
    @Column(name = "administrative_gender", length = 20) private String administrativeGender;
    @Column(length = 40) private String phone;
    @Column(length = 254) private String email;
    @Column(nullable = false) private boolean active = true;
    @Version private long version;
    @Column(name = "created_at", nullable = false, updatable = false) private Instant createdAt;
    @Column(name = "updated_at", nullable = false) private Instant updatedAt;

    protected Patient() {}

    public Patient(UUID organizationId, String mrn, String givenName, String familyName,
                   LocalDate dateOfBirth, String administrativeGender, String phone, String email) {
        this.id = UUID.randomUUID();
        this.organizationId = organizationId;
        this.mrn = mrn;
        this.givenName = givenName;
        this.familyName = familyName;
        this.dateOfBirth = dateOfBirth;
        this.administrativeGender = administrativeGender;
        this.phone = phone;
        this.email = email;
    }

    @PrePersist void onCreate() { Instant now = Instant.now(); createdAt = now; updatedAt = now; }
    @PreUpdate void onUpdate() { updatedAt = Instant.now(); }

    public UUID getId() { return id; }
    public UUID getOrganizationId() { return organizationId; }
    public String getMrn() { return mrn; }
    public String getGivenName() { return givenName; }
    public String getFamilyName() { return familyName; }
    public LocalDate getDateOfBirth() { return dateOfBirth; }
    public String getAdministrativeGender() { return administrativeGender; }
    public String getPhone() { return phone; }
    public String getEmail() { return email; }
    public boolean isActive() { return active; }
    public long getVersion() { return version; }
    public Instant getCreatedAt() { return createdAt; }
    public void deactivate() { active = false; }
}
