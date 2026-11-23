# ADR-001: Start with a modular monolith

Status: Accepted

## Context
The product has several related healthcare capabilities, but the domain and workflows are new to the development team. Starting with many independently deployed services would add operational overhead before boundaries are understood.

## Decision
Use one Spring Boot deployable with explicit domain modules and boundaries. Keep FHIR server external. Extract services only when scale, team ownership, deployment independence or bounded-context requirements justify it.

## Consequences
- Simpler local development and debugging.
- Easier transactional consistency for initial patient workflows.
- Requires package/module discipline to avoid a big ball of mud.
