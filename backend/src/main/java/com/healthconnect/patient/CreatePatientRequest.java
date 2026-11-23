package com.healthconnect.patient;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public record CreatePatientRequest(
    @NotBlank @Size(max = 100) String givenName,
    @NotBlank @Size(max = 100) String familyName,
    @NotNull @PastOrPresent LocalDate dateOfBirth,
    @Pattern(regexp = "^(male|female|other|unknown)$", flags = Pattern.Flag.CASE_INSENSITIVE,
             message = "must be male, female, other or unknown")
    String administrativeGender,
    @Size(max = 40) String phone,
    @Email @Size(max = 254) String email
) {}
