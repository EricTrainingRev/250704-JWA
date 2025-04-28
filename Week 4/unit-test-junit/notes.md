# Unit Testing
Whereas System tests allow for a level of generality when it comes to testing and reporting on the results of tests, Unit testing is a very precise and specific way of performing testing. The focus of unit tests are on individual components of an application: in order to do "true" unit testing, you have to test a resource in isolation from all* other resources. By "all" resources I specifically mean all resources that are "owned" by the team (think custom made by the team, produced by the team, work products). 

## Some Common Types of Unit Tests

### Statement Testing
Statement testing is your sterotypical form of software testing: you write a test method that calls another method (the test object) and validates the response. You could describe this kind of test as testing the "statement" being called

### Retesting
Anytime a test fails and a defect is discovered that defect needs to eventually be fixed. When the fix is completed the test that originally failed needs to be rerun as part of the validation process. Running the initially failed test again after a defect fix is called "Retesting". In other words, Retesting is validating that defects have been fixed by rerunning previously failed tests

### Regression Testing
Anytime a new feature or refactor is added to a service Regression testing can be done in order to validate the new code has not broken the old code.