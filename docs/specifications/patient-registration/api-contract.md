# Patient API contract (v1)

Base path: `/api/v1/patients`

## Create
`POST /api/v1/patients`

Request:
```json
{
  "givenName": "Jordan",
  "familyName": "Taylor",
  "dateOfBirth": "1990-04-21",
  "administrativeGender": "female",
  "phone": "404-555-0101",
  "email": "jordan@example.test",
  "address": {
    "line1": "100 Peachtree St",
    "city": "Atlanta",
    "state": "GA",
    "postalCode": "30303",
    "country": "US"
  }
}
```
Response: `201 Created`, patient representation and `Location` header.

## Read
`GET /api/v1/patients/{patientId}` -> `200 OK` or `404`.

## Search
`GET /api/v1/patients?mrn=...&givenName=...&familyName=...&dateOfBirth=YYYY-MM-DD&page=0&size=20`
- At least one search criterion required.
- Return paginated results.
- Search behavior and matching sensitivity documented in implementation.

## Update
`PUT /api/v1/patients/{patientId}`
- Requires expected version (initial implementation may use `If-Match`/ETag or explicit version field).
- MRN and organization ID are not editable.
- Stale version -> `409 Conflict` or `412 Precondition Failed`, consistently documented.

## Deactivate
`POST /api/v1/patients/{patientId}/deactivate`
- Retains record; does not physically delete.

## Error shape
```json
{
  "type": "VALIDATION_ERROR",
  "title": "Request validation failed",
  "status": 400,
  "detail": "One or more fields are invalid",
  "fieldErrors": [
    {"field": "dateOfBirth", "message": "must not be in the future"}
  ],
  "traceId": "..."
}
```
