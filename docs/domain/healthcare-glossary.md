# Healthcare glossary

- **Patient:** Person receiving healthcare services.
- **MRN (Medical Record Number):** Identifier assigned by a particular healthcare organization or facility; not universally unique.
- **MPI (Master Patient Index):** Identity-management capability used to identify and reconcile records believed to represent the same person.
- **EHR (Electronic Health Record):** Longitudinal digital health record that may span providers and care settings.
- **EMR (Electronic Medical Record):** Often refers to a digital record within one practice or organization; terminology varies by organization.
- **Encounter:** A healthcare interaction such as an office visit, emergency visit or telehealth consultation.
- **Provider:** Healthcare professional or organization participating in care. In FHIR, Practitioner and PractitionerRole represent distinct concepts.
- **PHI:** Protected Health Information under applicable US privacy rules.
- **FHIR:** HL7 Fast Healthcare Interoperability Resources, a standard for exchanging health information.
- **FHIR Patient:** FHIR resource representing demographic and administrative information about a person receiving care.
- **Administrative gender:** Administrative value represented by the FHIR Patient.gender element; do not conflate with gender identity.
- **US Core:** US implementation guide defining profiles and expectations for interoperable FHIR data exchange.
- **Audit event:** Record of who performed an action, what action occurred, when it occurred and its outcome.

## Important identity distinction
The internal HealthConnect patient UUID, organization-scoped MRN and FHIR logical resource ID are separate identifiers. Do not assume one can replace another.
