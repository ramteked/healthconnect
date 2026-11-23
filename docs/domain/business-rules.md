# Patient business rules

1. A patient must have a given name, family name and date of birth.
2. Date of birth must not be later than the current date in the organization's configured timezone.
3. MRN is unique within its assigning organization, not globally across all healthcare organizations.
4. Internal UUID, MRN and FHIR logical ID are separate identifiers.
5. MRN is assigned by the system and is immutable in ordinary demographic update workflows.
6. Duplicate detection returns candidate matches; it must never automatically merge records.
7. A deactivated patient is retained for historical integrity and may remain visible to authorized users.
8. Patient demographic updates use optimistic concurrency.
9. All create/update/deactivate operations produce audit events.
10. Logs must not contain patient demographics or clinical data.
11. Do not collect SSN for this learning application.
12. Use synthetic patient records only.
13. Administrative gender is optional and is not a substitute for gender identity.
14. Contact information is optional and should be validated when supplied.
