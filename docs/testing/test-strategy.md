# Test strategy

## Unit tests
- Required name validation and normalization.
- Date-of-birth validation.
- MRN generation and uniqueness retry.
- Duplicate candidate matching.
- Deactivation behavior.
- Optimistic locking behavior.

## Integration tests
- PostgreSQL repository and Flyway migrations.
- REST validation and status codes.
- Search filters and pagination.
- Transaction rollback behavior.
- FHIR adapter mapping and server error handling.

## Contract/interoperability tests
- FHIR Patient resource conforms to FHIR R4.
- Required identifiers include assigning system.
- Administrative gender maps only to permitted FHIR codes.
- FHIR server interactions are idempotent.

## Security/privacy tests
- Unauthorized requests rejected.
- Roles restricted by operation.
- Organization context cannot be overridden by request body.
- No PHI in application logs or error messages.
- Synthetic test fixtures only.

## Test data
Use invented names and reserved `.test` email domains. Never load real patient records.
