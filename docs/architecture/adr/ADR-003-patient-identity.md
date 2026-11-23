# ADR-003: Separate internal ID, MRN and FHIR ID

Status: Accepted

## Context
A patient can have multiple identifiers across facilities and systems. MRNs are typically assigned by an organization; FHIR resources have server-specific logical IDs.

## Decision
Use an internal UUID as the HealthConnect primary key. Assign an organization-scoped MRN. Store the FHIR server's Patient logical ID separately in an integration link.

## Consequences
- Prevents false assumptions that MRNs are globally unique.
- Allows multiple assigning authorities and future cross-organization matching.
- Supports FHIR server migration without changing internal patient identity.
