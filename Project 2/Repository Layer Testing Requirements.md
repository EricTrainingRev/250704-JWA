# Repository Layer Testing Requirements
This document outlines the testing requirements for the Repository layer of the Planetarium application

## User DAO
- All listed methods should have a Positive Integration Test validating functionality
- All listed methods should have Negative Integration Tests validating any associated requirements are enforced

### User creation
- **Method**: `createUser`
- **Input**: `User` object with `username` and `password` fields set
    - `id` should be set to 0
- **Expected Output**:
    - **Success**:
        - `User` object returned with assigned `id` inside an `Optional` object
    - **Failure**:
        - `SQLException`s should be unhandled
            - exception messages should indicate what constraint or rule was broken in the database

### User retrieval
- **Method**: `findUserByUsername`
- **Input**: username data as a `String` object 
- **Expected Output**:
    - **Success**:
        - `User` object returned inside an `Optional` object
    - **Failure**:
        - empty `Optional` object returned


## Planet DAO
- All listed methods should have a Positive Integration Test validating functionality
- All listed methods should have Negative Integration Tests validating any associated requirements are enforced

### Planet Creation
- **Method**: `createPlanet`
- **Input**: `Planet` object with `planetname`, `ownerId`, and optional `imageData` fields set
    - `planetId` should be set to 0
- **Expected Output**:
    - **Success**:
        - `Planet` object returned with assigned `planetId` inside an `Optional` object
    - **Failure**:
        - `SQLException`s should be unhandled
            - exception messages should indicate what constraint or rule was broken in the database

### Planet Retrieval for User
- **Method**: `readPlanetsByOwner`
- **Input**: User id as `int` primitive
- **Expected Output**:
    - **Success**:
        - `Planet` objects returned inside an `ArrayList` object
    - **Failure**:
        - empty `List` object returned

### Planet Deletion
- **Method**: `deletePlanet`
- **Input**: Planet name as "String" object
- **Expected Output**:
    - **Success**:
        - true `boolean`
    - **Failure**:
        - false `boolean`

## Moon DAO
- All listed methods should have a Positive Integration Test validating functionality
- All listed methods should have Negative Integration Tests validating any associated requirements are enforced

### Moon Creation
- **Method**: `createMoon`
- **Input**: `Moon` object with `moonName`, `ownerId` and optional `imageData` fields set
    - `id` should be set to 0
- **Expected Output**:
    - **Success**:
        - `Moon` object returned with assigned `moonId` inside an `Optional` object
    - **Failure**:
        - `SQLException`s should be unhandled
            - exception messages should indicate what constraint or rule was broken in the database


### Moon Retrieval for Planet
- **Method**: `readMoonsByPlanet`
- **Input**: planet id as `int` primitive
- **Expected Output**:
    - **Success**:
        - `Moon` objects returned inside an `ArrayList` object
    - **Failure**:
        - empty `List` object returned

### Moon Deletion
- **Method**: `deleteMoon`
- **Input**: moon name as "String" object
- **Expected Output**:
    - **Success**:
        - true `boolean`
    - **Failure**:
        - false `boolean`