# Initial relational data model

## patient
- id UUID primary key
- organization_id UUID not null
- mrn VARCHAR(40) not null
- given_name VARCHAR(100) not null
- family_name VARCHAR(100) not null
- date_of_birth DATE not null
- administrative_gender VARCHAR(20) null
- phone VARCHAR(40) null
- email VARCHAR(254) null
- address_line1 VARCHAR(150) null
- address_line2 VARCHAR(150) null
- city VARCHAR(100) null
- state VARCHAR(80) null
- postal_code VARCHAR(20) null
- country VARCHAR(2) null
- active BOOLEAN not null
- version BIGINT not null
- created_at TIMESTAMPTZ not null
- updated_at TIMESTAMPTZ not null

Constraints:
- primary key (id)
- unique (organization_id, mrn)
- date_of_birth <= current date (enforce in application and consider DB check)
- indexes for organization_id + mrn and normalized family_name/given_name + date_of_birth.

## patient_fhir_link (later task)
- patient_id UUID
- fhir_base_url
- fhir_resource_type (Patient)
- fhir_resource_id
- last_sync_status
- last_sync_at
- last_error_code (no PHI)
- unique(patient_id, fhir_base_url)

## audit_event (later task)
- id UUID
- actor_id
- organization_id
- action
- resource_type
- resource_id
- occurred_at TIMESTAMPTZ
- outcome
- correlation_id
- details should be minimized and must not contain unnecessary PHI.

Do not put insurance coverage, encounters, diagnoses or medications into the patient table.
