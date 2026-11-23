# HealthConnect — Milestone 1

Healthcare Patient Registration & Medical Record Management.

## Baseline
- Java 24
- Spring Boot 3.5.x (pinned to 3.5.16 in the starter POM)
- Maven
- PostgreSQL 16
- Angular 22 (Node.js 22.22.3 or 24.15.0+)
- HAPI FHIR R4 server as a separate integration

This is a learning/portfolio system using synthetic data only. It is not a production EHR and is not HIPAA certified.

## Repository layout
- `docs/`: product, domain, architecture, ADRs, feature specifications and test strategy
- `backend/`: Spring Boot starter module
- `infrastructure/docker/`: local PostgreSQL
- `frontend/`: create Angular application here using the instructions below

## Mac setup
1. Install Homebrew if needed: https://brew.sh/
2. Install Java 24 and Maven:
   ```bash
   brew install openjdk@24 maven
   ```
   Configure `JAVA_HOME` according to Homebrew's post-install message, then verify:
   ```bash
   java -version
   mvn -version
   ```
3. Install Docker Desktop: https://docs.docker.com/desktop/setup/install/mac-install/
4. Start Docker Desktop.
5. From the repository root:
   ```bash
   docker compose -f infrastructure/docker/docker-compose.yml up -d
   ```
6. Create backend database schema through Flyway when the backend starts.
7. Run backend:
   ```bash
   cd backend
   mvn spring-boot:run
   ```
8. Create Angular app from repository root:
   ```bash
   npx @angular/cli@22 new frontend --routing --style=scss --standalone
   cd frontend
   npm start
   ```

Angular 22 requires a supported Node version. Check `node -v`; use Node 22.22.3+ or 24.15.0+ rather than Node 24.14.1.

## Local endpoints
- Backend: http://localhost:8081
- Health: http://localhost:8081/actuator/health (actuator endpoint can be enabled in a later task)
- PostgreSQL: localhost:5432, database `healthconnect`, user `hc_app`
- FHIR server: planned for a later integration task, separate from the app database

## First implementation scope
The backend starter begins the Patient aggregate and REST API. FHIR synchronization, authentication, audit persistence, duplicate matching and Angular screens are specified as follow-on tasks in Milestone 1. Do not represent those as completed until implemented and tested.
