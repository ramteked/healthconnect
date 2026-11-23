# Product Requirements Document — HealthConnect

## 1. Product vision
Build a realistic learning/portfolio healthcare platform that demonstrates patient identity and demographic workflows, clinical record foundations, interoperability using HL7 FHIR R4, secure application design and senior-level backend engineering.

## 2. Intended users
- Registration clerk: registers and updates patient demographics.
- Front-desk staff: searches and verifies patient identity.
- Clinician: later views patient information and documents encounters.
- System administrator: later manages organization, users and access.
- Patient: future patient-portal persona; not in Milestone 1.

## 3. Milestone 1 outcome
An authorized staff user can register a patient, receive an organization-scoped Medical Record Number (MRN), search and view a patient, update demographics, deactivate a record, and see possible duplicate warnings. Changes are auditable. Patient data can be represented as an HL7 FHIR R4 Patient resource through an integration adapter.

## 4. In scope
- Patient demographics and contact details.
- Organization-scoped MRN.
- Patient create/read/search/update/deactivate.
- Input validation and duplicate candidate detection.
- Optimistic concurrency.
- Audit events.
- FHIR R4 Patient mapping and synchronization design.
- Angular patient search, registration and detail screens.
- PostgreSQL persistence and automated tests.

## 5. Out of scope for Milestone 1
- Clinical diagnosis, medication prescribing, laboratory orders/results.
- Insurance eligibility, claims, billing and revenue cycle.
- Real patient data or production clinical use.
- Automatic patient identity merge.
- Production HIPAA compliance certification.
- Multi-tenant production hosting.

## 6. Success measures
- Patient can be registered and retrieved through API and UI.
- MRN uniqueness is enforced by the database.
- Invalid dates and required-field omissions are rejected.
- Concurrent updates do not silently overwrite each other.
- Search supports MRN and demographic matching with pagination.
- FHIR Patient representation passes R4 validation for the fields we populate.
- Tests cover domain rules, API validation, persistence and integration failure paths.
