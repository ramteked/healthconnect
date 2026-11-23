# Acceptance criteria — patient registration

- Given valid demographics, when registration is submitted, then a patient is persisted and a unique organization-scoped MRN is returned.
- Given a missing name, when submitted, then a field-level validation error is returned.
- Given a future date of birth, when submitted, then registration is rejected.
- Given an existing exact MRN, then the database prevents a duplicate within the same organization.
- Given likely duplicate demographics, then candidate records are shown for human review and no merge occurs.
- Given a stale version on update, then the update is rejected rather than overwriting newer data.
- Given deactivation, then the patient remains retrievable by authorized historical workflows and is marked inactive.
- Given FHIR server downtime, then local patient registration is not lost and synchronization remains retryable.
- Given any patient mutation, then an audit event is recorded.
- Given an application log, then it contains no patient name, DOB, phone, email, address or clinical content.
