CREATE TABLE patient (
    id UUID PRIMARY KEY,
    organization_id UUID NOT NULL,
    mrn VARCHAR(40) NOT NULL,
    given_name VARCHAR(100) NOT NULL,
    family_name VARCHAR(100) NOT NULL,
    date_of_birth DATE NOT NULL,
    administrative_gender VARCHAR(20),
    phone VARCHAR(40),
    email VARCHAR(254),
    active BOOLEAN NOT NULL DEFAULT TRUE,
    version BIGINT NOT NULL DEFAULT 0,
    created_at TIMESTAMPTZ NOT NULL,
    updated_at TIMESTAMPTZ NOT NULL,
    CONSTRAINT uk_patient_org_mrn UNIQUE (organization_id, mrn),
    CONSTRAINT ck_patient_dob_not_future CHECK (date_of_birth <= CURRENT_DATE)
);

CREATE INDEX idx_patient_org_name_dob
    ON patient (organization_id, family_name, given_name, date_of_birth);
