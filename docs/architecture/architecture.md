# HealthConnect architecture

## Context
Angular SPA -> Spring Boot REST API -> modular monolith -> PostgreSQL.
The application integrates with a separate HAPI FHIR R4 server through a FHIR adapter.

## Logical modules
- patient: patient aggregate, identity and demographics.
- organization: assigning authority and organization configuration.
- audit: security/audit event recording.
- interoperability.fhir: FHIR mapping, client and synchronization.
- shared: error handling, clock, pagination and common primitives.

## Request flow
Angular -> REST controller -> application service -> domain rules -> repository -> PostgreSQL.
FHIR synchronization is initiated through an application event/outbox workflow. The domain model must not depend on HAPI model classes.

## Data ownership
- HealthConnect PostgreSQL owns the application's operational patient record.
- HAPI FHIR server owns its own FHIR persistence database.
- Do not share tables or connect the application ORM directly to HAPI's schema.
- FHIR resource IDs are stored as external references/mappings, not used as internal primary keys.

## Reliability
- Use a transactional outbox for reliable asynchronous FHIR synchronization when that capability is implemented.
- Retry transient FHIR failures with bounded exponential backoff.
- Make synchronization idempotent.
- Track synchronization state and last error without copying PHI into logs.
- Do not claim synchronization succeeded until the FHIR server confirms it.

## Security baseline
- OAuth2/OIDC authentication and role-based authorization are planned.
- Enforce least privilege and organization context.
- Use TLS outside local development.
- Protect secrets using environment variables locally and a secrets manager in deployment.
- Audit access and mutations; avoid sensitive data in logs.
- This design is a learning baseline, not a certification or production security assessment.
