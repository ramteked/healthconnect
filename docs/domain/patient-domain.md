# Patient domain model

## Patient aggregate (Milestone 1)
- `id`: internal UUID, immutable.
- `organizationId`: organization owning the record (single demo organization initially).
- `mrn`: organization-scoped medical record number, immutable after assignment.
- `givenName`, `familyName`: required names.
- `dateOfBirth`: required local calendar date; cannot be in the future.
- `administrativeGender`: optional coded value; map only to supported FHIR administrative gender codes.
- `phone`, `email`: optional contact methods.
- `address`: optional postal address.
- `active`: whether the record is active for routine workflows; deactivation does not erase history.
- `version`: optimistic-lock version.
- `createdAt`, `updatedAt`: UTC timestamps.

## Related concepts (later milestones)
- PatientIdentifier: additional identifiers and assigning authorities.
- Coverage: insurance coverage; not merely a column on Patient.
- Encounter: visit/interaction.
- Condition: diagnosis/problem.
- Observation: vitals and lab observations.
- MedicationRequest: medication order/prescription.
- AllergyIntolerance: allergy/intolerance.
- Practitioner / PractitionerRole: provider identity and role.

## Boundaries
Patient demographics are not the same thing as clinical history, insurance coverage or a visit. Keep those as separate domain concepts and later FHIR resources.
