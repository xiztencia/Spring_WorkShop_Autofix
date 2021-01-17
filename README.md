# Spring WorkShop Autofix
## **Project creation**

- This Springboot project for the Java 19 course from ITHS was developed by Nicklas Johansson and Luis Gutierrez, Elena Ten, Rauf Rajput.

## **Projects obstacles**

- The most diffuculty in our project was to figure out the proper functionality for Security tokens and Spring Session. Here we had to split into separate api and web security classes.  

![](https:/xiztencia/github.com//Spring_Workshop_Autofix/workflows/Java%20CI/badge.svg)

# Endpoints 
## [Client](#endpoint-1)
## [Employee](#endpoint-2)
## [SparePart](#endpoint-3)
## [Maintenance](#endpoint-4)
## [Vehicle](#endpoint-5)

[![CircleCI](https://circleci.com/<VCS>/<ORG_NAME>/<PROJECT_NAME>.svg?style=svg&circle-token=<YOUR_STATUS_API_TOKEN>)](<LINK>)
# POST
|Method|Description|URL|
|---|---|--|
|POST|Create a user client to registry|http://localhost:8080/api/client/create|
```ruby
{
	"username":"Kalle",
	"email":"kalle@ankeborg.org",
	"password":"skuldberg"
}
```
|Response Body Exemple|
|---|
```ruby
  {
  "id": 16,
  "username": "Kalle",
  "firstname": null,
  "lastname": null,
  "email": "kalle@ankeborg.org",
  "password": "$2a$10$Z..kRuBj25u7flA14X3aJOqto0zQ.P91U0JsWYyZzji/dQvmBSJri",
  "vehicles": [],
  "maintenances": [],
  "spareParts": []
}
```
|Method|Description|URL|
|---|---|--|
|POST|Get user token |http://localhost:8080/api/authenticate|
```ruby
{
	"username":"Kalle",
	"password":"skuldberg"
}
```
|Response Body Example|
|---|
```ruby
{
  "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJLYWxsZSIsImV4cCI6MTYxMDkwNzkyNCwiaWF0IjoxNjEwOTA3MzI0fQ.SnK3jnS3IeQsU5R5pS5qExjHecmPCsX5eyFmLYBQJvqv58Nns0Wg547d9wJK6LPCB5wxzhzQDd7OS_CC_jZQbg"
}  
 ```
 |Method|Description|URL|
|---|---|--|
|GET|Get student with given last name|http://localhost:8080/student-management-system/api/v1/student/searchByLastName/{lastname}|

|Response Body Example||
|---|---|
|Example URL| http://localhost:8080/student-management-system/api/v1/student/searchByLastName/Gutierrez|
 
```ruby
  [
  {
    "email": "luis@google.com",
    "firstname": "Luis",
    "id": 1,
    "lastname": "Gutierrez",
    "phonenumber": "555-2343"
  },
  {
    "email": "erick@google.com",
    "firstname": "Erick",
    "id": 2,
    "lastname": "Gutierrez",
    "phonenumber": "555-2673"
  }
]
 ```

# POST
|Method|Description|URL|
|---|---|--|
|POST|Create a new student record in registry|http://localhost:8080/student-management-system/api/v1/student/new|

|Request Body Example|
|---|
```ruby
{
  "email": "example@iths.se",
  "firstname": "Ronald",
  "lastname": "McDonald",
  "phonenumber": "555-2249"
}

```
|Response Body Example|
|---|
```ruby
{
  "email": "example@iths.se",
  "firstname": "Ronald",
  "id": 7,
  "lastname": "McDonald",
  "phonenumber": "555-2249"
}

```

# PUT
|Method|Description|URL|
|---|---|--|
|PUT|Update an existing student record in registry|http://localhost:8080/student-management-system/api/v1/student/update|

|Request Body Example and Response Body Example|
|---|
```ruby
{
  "email": "rob@google.com",
  "firstname": "Robbie",
  "id": 5,
  "lastname": "Sam",
  "phonenumber": "555-3639"
}

```

# DELETE
|Method|Description|URL|
|---|---|--|
|DELETE|Remove an existing student with given ID from registry|http://localhost:8080/student-management-system/api/v1/student/deleteById/{id}|

|Response Body Example||
|---|---|
|Example URL| http://localhost:8080/student-management-system/api/v1/student/deleteById/3|

```ruby
Student with ID 3 removed from registry
```
