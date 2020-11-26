# Spring WorkShop Autofix
## **Project creation**

- This Springboot project for the Java 19 course from ITHS was developed by Nicklas Johansson and Luis Gutierrez, Elena Ten, Rauf Rajput.

## **Projects obstacles**

- Bla bla bla

![](https:/xiztencia/github.com//Spring_Workshop_Autofix/workflows/Java%20CI/badge.svg)

# Endpoints
## [Endpoint](#endpoint-1)
## [Endpoint](#endpoint-2)

[![CircleCI](https://circleci.com/<VCS>/<ORG_NAME>/<PROJECT_NAME>.svg?style=svg&circle-token=<YOUR_STATUS_API_TOKEN>)](<LINK>)
# GET
|Method|Description|URL|
|---|---|--|
|GET|Get all students from registry|http://localhost:8080/student-management-system/api/v1/student/getall|

|Response Body Exemple|
|---|
```ruby
  {Någon : JsonObject}
```
|Method|Description|URL|
|---|---|--|
|GET|Get student with given ID|http://localhost:8080/student-management-system/api/v1/student/searchById/{id}|

|Response Body Example||
|---|---|
|Example URL| http://localhost:8080/student-management-system/api/v1/student/searchById/2|

```ruby
  {
  "Någon":"JSON OBject"
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
