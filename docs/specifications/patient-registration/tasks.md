# Implementation tasks — Milestone 1

## M1.1 Domain and persistence
- [ ] Create Patient aggregate and value objects.
- [ ] Add Flyway migration and unique organization/MRN constraint.
- [ ] Add optimistic locking.
- [ ] Add repository and persistence tests.

## M1.2 REST API
- [ ] Create request/response DTOs.
- [ ] Implement create/read/search/update/deactivate endpoints.
- [ ] Add validation and consistent error responses.
- [ ] Add pagination and sorting.
- [ ] Add API integration tests.

## M1.3 Patient identity
- [ ] Implement organization-scoped MRN generation.
- [ ] Add possible-duplicate candidate search.
- [ ] Document that candidate matching does not merge records.

## M1.4 Audit and security
- [ ] Add actor and organization context.
- [ ] Persist audit events for create/update/deactivate.
- [ ] Add OAuth2/OIDC login and role-based access.
- [ ] Add log redaction tests.

## M1.5 FHIR
- [ ] Start separate HAPI FHIR R4 server.
- [ ] Implement Patient-to-FHIR mapping.
- [ ] Implement FHIR client create/read/update.
- [ ] Persist FHIR resource link.
- [ ] Add outbox, retries and idempotency.
- [ ] Validate against FHIR R4 and selected US Core profile requirements.

## M1.6 Angular
- [ ] Patient search/list screen.
- [ ] Patient registration form.
- [ ] Patient detail screen.
- [ ] Edit/deactivate workflow.
- [ ] Field-level validation and API error handling.
- [ ] Accessibility and responsive layout.
