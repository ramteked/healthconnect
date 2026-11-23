# Feature specification: Patient registration

## Goal
Allow authorized registration staff to create a patient record with validated demographics and an organization-scoped MRN.

## Primary actor
Registration clerk.

## Preconditions
- User is authenticated and authorized (authentication wiring is a separate implementation task).
- Organization context is available.

## Main flow
1. Clerk opens patient registration.
2. Enters required name and date of birth.
3. Optionally enters administrative gender, phone, email and postal address.
4. System validates fields and date of birth.
5. System searches for possible duplicates using configured matching rules.
6. If possible matches exist, show a warning and allow authorized staff to review; do not auto-merge.
7. On confirmation, system creates patient and assigns MRN.
8. System persists patient and audit event.
9. System schedules FHIR synchronization through an outbox (later implementation task).
10. UI displays patient summary and MRN.

## Validation
- givenName and familyName required; trim whitespace.
- dateOfBirth required and not in future.
- email valid if present.
- administrativeGender, if present, must be one of the supported values.
- MRN assigned by server, never accepted from ordinary create request.
- organizationId comes from trusted authenticated context, not an arbitrary client field.

## Failure behavior
- Validation error: HTTP 400 with field-level details.
- Possible duplicate: return candidates/warning; no silent merge.
- MRN collision: retry generation or return controlled server error after bounded retries.
- Persistence failure: no partial patient record.
- FHIR unavailable: local registration remains recorded; synchronization remains pending and is retried.

## Privacy
Use synthetic data only. Never log request bodies or patient demographics.
