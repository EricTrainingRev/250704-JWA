# Test Schedule
This document contains the Test schedule for the second sprint of the Planetarium project. It is organized by the Standard Testing Life Cycle phases, and includes entry and exit criteria for each phase.

## STLC Phases

### Phase 1: Test Analysis
In this phase, the testing team reviews and analyzes the requirements to understand what needs to be tested. They clarify any doubts with stakeholders and update their Requirement Traceability Matrix (RTM) to ensure all requirements will be covered by test cases. This is also when a shared Github repository is created and contributors are added

**Entry Criteria:**
- Test Documentation is available
- Stakeholder is available for clarification

**Exit Criteria:**
- Requirements are understood
- Requirement Traceability Matrix is updated with new resources
- Team GitHub repo is created and team members are added as contributors

### Phase 2: Test Planning
This phase involves planning the testing activities. Previously determined test basis are used to identiy test conditions, and the RTM is updated to map any new requirements with pre-existing resources. The team updates a Jira Scrum Project with a new sprint: organizing issues into epics, stories, and subtasks, based off the test conditions they determined, and assign story points to each issue to estimate the time effort required

**Entry Criteria:**
- RTM is available
- Test basis determined

**Exit Criteria:**
- New sprint created in a Jira Scrum Project and team members are added
- New issues organized into epics, stories, and subtasks
- Story points assigned to issues

### Phase 3: Test Case Design
Test cases are designed based on the test conditions determined in the previous phase. The team determines the necessary test data for the integration and unit tests, and appropriate storage solutions are leveraged to facilitate the testing process

**Entry Criteria:**
- RTM updated as needed
- Scrum Issues organized

**Exit Criteria:**
- Test data determined
- Storage solutions for test data created

### Phase 4: Test Environment Setup
The test environment is prepared to ensure it mimics the production environment. The team sets up the test application and configures the environment to support the Planetarium application

**Entry Criteria:**
- Test data prepared
- Planetarium application available

**Exit Criteria:**
- Test suites created
- Environment configured for the Planetarium to function properly

### Phase 5: Test Execution
The final testing is performed in this phase. The team executes the test cases and generates test reports

**Entry Criteria:**
- Test application present
- Planetarium configured to run

**Exit Criteria:**
- Tests executed successfully
- Test reports generated successfully

### Phase 6: Test Cycle Closure
This final phase involves wrapping up the testing activities. The team reviews the test results and creates defect reports for any issues found, linking them to the appropriate issues

**Entry Criteria:**
- Test results available

**Exit Criteria:**
- Defect reports created and linked to appropriate issues
- Test results saved in a centralized location

### Post Test Lifecycle
Once the Testing Lifecycle has been completed work on the new [SRS](Software%20Requirement%20Specifications.md) requirements should begin

