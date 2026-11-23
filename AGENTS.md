# Repository instructions for AI coding agents

## Product context
HealthConnect is a synthetic-data healthcare learning application. Milestone 1 focuses on patient registration and patient record management.

## Engineering rules
- Use Java 24, Spring Boot 3.5.x, Maven and PostgreSQL.
- Use Angular standalone components and strict TypeScript.
- Keep the application a modular monolith initially; do not introduce microservices without an ADR.
- Keep healthcare domain rules in domain/application layers, not controllers.
- Use DTOs at API boundaries. Never expose JPA entities directly.
- Validate input at API boundaries and enforce invariants in the domain/application layer.
- Use Flyway migrations; do not rely on Hibernate schema auto-update.
- Use optimistic locking for mutable patient records.
- Use UTC instants for audit timestamps.
- Do not log patient names, dates of birth, contact details, addresses, identifiers, or clinical information.
- Use synthetic test data only. Never use real patient data.
- Do not collect SSNs.
- Do not automatically merge possible duplicate patients.
- Keep organization-scoped MRNs distinct from FHIR logical IDs and any cross-organization identity.
- FHIR R4 mapping belongs in an adapter/anti-corruption layer; do not make FHIR resource classes the internal domain model.
- Add unit and integration tests for business rules and API behavior.
- Update the relevant specification and ADR when behavior or architecture changes.

## Workflow
1. Read the relevant PRD, domain glossary, feature spec, API contract and acceptance criteria.
2. Identify unclear requirements before coding.
3. Propose the smallest implementation plan.
4. Implement and test.
5. Report files changed, tests run, limitations and remaining tasks.
