# Typical Workflow

## Start Grid

`docker compose up -d`

### Run tests:

`mvn clean verify`

### Run tests against specific browser:

- **Chrome**:  `mvn clean verify -Dwebdriver.driver=chrome`
- **FireFox:** `mvn clean verify -Dwebdriver.driver=firefox`
- **Edge:** `mvn clean verify -Dwebdriver.driver=edge`

### Parallel Execution

`mvn clean verify -Dwebdriver.driver=chrome -Dserenity.parallel.threads=3`

### Stop grid:

`docker compose down`

### CI Pipeline

1. checkout & build code
2. start Docker Selenium Grid
3. run tests in parallel
4. collect serenity report
5. publish report

> Large Serenity + Cucumber test suites are partitioned using tags and Maven profiles.
> CI pipelines execute each profile in separate parallel jobs connected to Selenium Grid,
> allowing independent browser sessions and significantly reducing total execution time.
