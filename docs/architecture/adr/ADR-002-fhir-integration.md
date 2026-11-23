# ADR-002: Integrate with a separate HAPI FHIR R4 server

Status: Accepted

## Context
The project must demonstrate interoperability without turning its internal database schema into a FHIR implementation.

## Decision
HealthConnect owns its operational patient model. A dedicated adapter maps it to/from HL7 FHIR R4 Patient resources. HAPI FHIR JPA server runs separately with its own database.

## Consequences
- Internal domain model remains stable if FHIR mapping changes.
- FHIR synchronization needs retry, idempotency and reconciliation.
- FHIR logical IDs are external references, not HealthConnect patient IDs.
- HAPI starter defaults and security must be reviewed; do not expose an unsecured server publicly.
