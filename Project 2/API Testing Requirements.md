# API Requirements
This document contains the endpoint data that needs to be tested via integration testing for the Planetarium API. The jsons provided are templates showing the structure of the expected request and response bodies. Hard coded responses are provided where applicable, otherwise placeholder values are used

## User Endpoints
### Login
- **Method**: POST
- **URL**: `/login`
- **Body**:
```json
{
    "username":"",
    "password":""
}
```
- **Response**:
    - status code:
        - success: 200
        - fail: 401
```json
// success
{
    "id": 0,
    "username": "",
    "password":null
}
```
```json
// fail
{
    "message": "Invalid credentials"
}
```

### Register
- **Method**: POST
- **URL**: `/register`
- **Body**:
```json
{
    "username":"",
    "password":""
}
```
- **Response**:
    - status code:
        - success: 201
        - fail: 400
```json
// success
{
    "message": "User created successfully",
}
```
```json
// fail: invalid username
{
    "message": "Invalid username",
}
```
```json
// fail: invalid password
{
    "message": "Invalid password",
}
```

### Logout
- **Method**: POST
- **URL**: `/logout`
- **Body**: None
- **Response**:
    - status code: 401


## Planet Endpoints
### Get Planets by Owner ID
- **Method**: GET
- **URL**: `/planetarium/user/{ownerId}/planet`
- **Body**: None
- **Response**:
    - status code: 200
```json
[
    {
        "planetId": 0,
        "planetName": "",
        "ownerId": 0,
        "imageData": ""
    },
    ...
]
```
### Create Planet
- **Method**: POST
- **URL**: `/planetarium/user/{ownerId}/planet`
- **Response**:
    - success: 201
    - fail: 400
- **Body**:
```json
// with image data
{
    "planetName": "",
    "ownerId": 0,
    "imageData": ""
}
```
```json
// without image data
{
    "planetName": "",
    "ownerId": 0
}
```
- **Response**:
    - status code:
        - success: 201
        - fail: 400
```json
// fail: Invalid name
{
    "message": "Invalid planet name",
}
```
```json
// fail: Invalid owner ID
{
    "message": "Invalid owner identifier",
}
```
```json
// fail: invalid file type
{
    "message": "Invalid file type"
}
```
### Delete Planet
- **Method**: DELETE
- **URL**: `/planetarium/owner/{ownerId}/planet/{planetName}`
- **Body**: None
- **Response**:
    - status code:
        - success: 204
        - fail: 400
```json
// fail: no planet with given name
{
    "message": "Invalid planet name",
}
```
```json
// fail: planet not owned by the user
{
    "message": "Invalid planet name",
}
```

## Moon Endpoints
### Get Moons by User ID
- **Method**: GET
- **URL**: `/planetarium/user/{userId}/moon`
- **Body**: None
- **Response**:
    - status code: 200
```json
[
    {
        "moonId": 0,
        "moonName": "",
        "ownerId": 0,
        "imageData": ""
    },
    ...
]
```
### Create Moon
- **Method**: POST
- **URL**: `/planetarium/planet/{planetId}/moon`
- **Body**:
```json
// with image data
{
    "moonName": "",
    "ownerId": 0,
    "imageData": ""
}
```
```json
// without image data
{
    "moonName": "",
    "ownerId": 0
}
```
- **Response**:
    - status code:
        - success: 201
        - fail: 400
```json
// fail: Invalid moon name
{
    "message": "Invalid moon name"
}
```
```json
// fail: Invalid owning planet
{
    "message": "Invalid planet identifier"
}
```
```json
// fail: Invalid file type
{
    "message": "Invalid file type"
}
```
### Delete Moon
- **Method**: DELETE
- **URL**: `/planetarium/planet/{planetId}/moon/{identifier}`
- **Body**: None
- **Response**:
    - status code:
        - success: 204
        - fail: 404
```json
// fail: invalid moon name
{
    "message": "Invalid moon name",
}
```
```json
// fail: Invalid owning planet
{
    "message": "Invalid planet identifier"
}
```