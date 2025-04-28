# Planetarium Sprint 2
The Planetarium is a web application designed by Revature Space Initiative for astronomers to track celestial bodies they discover in the night sky. Development work on the application is progressing, and the company wants to capitalize on the work of the testers brought on to the project. Your first job this Sprint is to explore the source code of the planetarium and create Integration and Unit tests for the application. Second, there is a large collection of new requirements that need to be implemented: these requirements should be worked on after the initial testing work is completed

## Project Technology Focus
- Java
- Selenium
- Cucumber
- Junit
- Mockito
- Jira
- Test Case Creation
- Test Reporting
- System Testing
- Integration Testing
- Unit Testing
- DevOps
- Jenkins
- AWS

## Setup Requirements

### Database Setup
- an environment variable called "DATABASE_URL" needs to be set with the JDBC url for the planetarium database
    - SQLite3 is used by the application
- a database needs to be created and set up for the planetarium to work properly. Use the ```setup-reset.sql``` file to create the database at the same location as your "DATABASE_URL" environment variable

### Webserver Setup
- an environment variable called "PLANETARIUM_URL" needs to be set with the url for the webserver
    - if running the app locally set it to "localhost:8080"
    - if running in the cloud set it to "{public ip or dns}:8080"
- an optional environment variable called `ENVIRONMENT` can be set to the value `test` to enable a `/reset` route that can be used for testing purposes

### Application start
- start the application with the command `java -jar path/to/Planetarium.jar`
- Note: the Planetarium Jar also allows for providing the setup data at runtime:
```bash
java -jar Planetarium.jar --database-url "url goes in quotes, relative to cwd" --planetarium-url localhost:8080 --environment test
```
