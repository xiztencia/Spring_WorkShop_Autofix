# Spring WorkShop Autofix
## **Project creation**

- This is a car dealership for vehicle, maintenance and spare parts sale for all makes and model. The project is developed with Spring Boot for our Java 19 course ComplexJava. While the Backend is done in Spring Boot we also have used PostgrSQL for our database maintenance, Thymeleaf
for our frontend and Heroku for deployment.

Project is developed by:
```ruby
L, Gutierrez
```
```ruby
E, Ten 
```
```ruby
R, Rajput
```
```ruby
N, Johansson
```
## **Projects obstacles**

- The most diffuculty in our project was to figure out the proper functionality for Security tokens and Spring Session. Here we had to split into separate api and web security classes.  

![](https:/xiztencia/github.com//Spring_Workshop_Autofix/workflows/Java%20CI/badge.svg)

# Endpoints 
## [Client](#client-1)
## [Employee](#employee-1)
## [SparePart](#sparepart-1)
## [Maintenance](#maintenance-1)
## [Vehicle](#vehicle-1)


# Client
# POST
|Method|Description|URL|
|---|---|--|
|POST| Create a user client to registry |http://localhost:8080/api/client/create|
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
|POST| Get user token |http://localhost:8080/api/authenticate|
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
# PUT
|Method|Description|URL|
|---|---|--|
|PUT| Update user client in registry |http://localhost:8080/api/client/update/{id}|
```ruby
{
	"username":"user",
	"firstname":"Anka",
	"password":"godkomplex"
}
```
|Response Body Example|
|---| 
```ruby
{
  "id": 3,
  "username": "user",
  "firstname": "Anka",
  "lastname": null,
  "email": null,
  "password": "$2a$10$5wQTwu9Mg458kOTt.Uc.UeWVd9phBt9nyBiOjp7bEP6hPxjxoQ1k2",
  "vehicles": [],
  "maintenances": [],
  "spareParts": []
}
```
# GET
|Method|Description|URL|
|---|---|--|
|GET| Find all clients from registry |http://localhost:8080/api/client/findall|

|Response Body Exemple|
|---|
```ruby
[
  {
    "id": 3,
    "username": "user",
    "firstname": "user",
    "lastname": "user",
    "email": "user",
    "password": "$2a$10$e7TIdM/C4U3sIgrMrbJ69.fBWTrrAxTdAQRCur7lz4nhEmc/d2hN6",
    "vehicles": [],
    "maintenances": [],
    "spareParts": []
  },
  {
    "id": 5,
    "username": "user2",
    "firstname": "Jn",
    "lastname": "Doe",
    "email": "jhon_doe@google.com",
    "password": "$2a$10$gi8r0PWZ6mxzhDogc84aduS2mUyeKpBBVM9pQ5FBqpywwVbsrkqBS",
    "vehicles": [],
    "maintenances": [],
    "spareParts": []
  }
]
```
|Method|Description|URL|
|---|---|--|
|GET| Find a user client by id from registry |http://localhost:8080/api/client/id/{id}|

|Response Body Example|
|---|
```ruby
{"id":3,"username":"user","firstname":"Anka","lastname":null,"email":null,"password":"$2a$10$5wQTwu9Mg458kOTt.Uc.UeWVd9phBt9nyBiOjp7bEP6hPxjxoQ1k2","vehicles":[],"maintenances":[],"spareParts":[]}
```
# DELETE
|Method|Description|URL|
|---|---|--|
|DELETE| Remove an existing user client with given ID from registry |http://localhost:8080/api/client/delete/{id}|

|Response Body Example|
|---|

```ruby
Deleted Client with id: 3
```


# Employee
# POST
|Method|Description|URL|
|---|---|--|
|POST| Create a user employee to registry |http://localhost:8080/api/employee/create|
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
  "id": 11,
  "username": "Kalle",
  "firstname": null,
  "lastname": null,
  "email": "kalle@ankeborg.org",
  "password": "$2a$10$84q00vyscEmUJ30MVJR9Huj4bLPvIMnBmiuPmFH/GugwwSUrrC916"
}
```
|Method|Description|URL|
|---|---|--|
|POST| Get user token |http://localhost:8080/api/authenticate|
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
# PUT
|Method|Description|URL|
|---|---|--|
|PUT| Update user employee in registry |http://localhost:8080/api/employee/update/{id}|
```ruby
{
	"username":"user",
	"firstname":"Luigi",
	"password":"godkomplex"
}
```
|Response Body Example|
|---| 
```ruby
{
  "id": 1,
  "username": "admin",
  "firstname": "Luigi",
  "lastname": null,
  "email": null,
  "password": "$2a$10$mToxj3TdFIaPFoAf3gpAiOIH6B.oC6rGDZMD1nj7kqsHIN8dT/UMC"
}
```
# GET
|Method|Description|URL|
|---|---|--|
|GET| Find all employees from registry |http://localhost:8080/api/employee/findall|

|Response Body Exemple|
|---|
```ruby
[
  {
    "id": 1,
    "username": "admin",
    "firstname": "admin",
    "lastname": "admin",
    "email": "admin",
    "password": "$2a$10$2HqBA7Vg.ee533ZCtFsS4O2iWK0k/T8/L8Jiu2JlwCo4bfSpXSvNW"
  }
]
```
|Method|Description|URL|
|---|---|--|
|GET| Find a user employee by id from registry |http://localhost:8080/api/employee/id/{id}|

|Response Body Example|
|---|
```ruby
{"id":1,"username":"admin","firstname":"admin","lastname":"admin","email":"admin","password":"$2a$10$2HqBA7Vg.ee533ZCtFsS4O2iWK0k/T8/L8Jiu2JlwCo4bfSpXSvNW"}
```
# DELETE
|Method|Description|URL|
|---|---|--|
|DELETE| Remove an existing user employee with given ID from registry |http://localhost:8080/api/employee/delete/{id}|

|Response Body Example|
|---|

```ruby
Deleted Employee with id: 11
```


# SparePart
# POST
|Method|Description|URL|
|---|---|--|
|POST| Create a spare part category that only admin can do, if you don't put any sparepart and send an error message will occur "Fill in spare part name" |http://localhost:8080/api/sparepart/create|
```ruby
{
    "part":"car wheel",
    "category":"wheels",
    "price":"549.0",
    "quantity":"2"
}
```
|Response Body Exemple|
|---|
```ruby
{
  "id": 13,
  "part": "car wheel",
  "category": "wheels",
  "price": 549.0,
  "quantity": 2,
  "client": null
}
```
# GET 
|Method|Description|URL|
|---|---|--|
|GET| Find all spare parts in registry |http://localhost:8080/api/sparepart/findall

|Response Body Example|
|---|
```ruby
[
  {
    "id": 7,
    "part": "car wheel",
    "category": "wheels",
    "price": 800.0,
    "quantity": 1,
    "client": null
  },
  {
    "id": 8,
    "part": "back wheel",
    "category": "mirrors",
    "price": 549.0,
    "quantity": 1,
    "client": null
  },
  {
    "id": 9,
    "part": "front light",
    "category": "lights",
    "price": 1200.0,
    "quantity": 2,
    "client": null
  }
]
```
|Method|Description|URL|
|---|---|--|
|GET| Find a spare part by id in registry. If wrong ID is entered the message "The spare part id was not found" will occur |http://localhost:8080/api/sparepart/id/{id}|

|Response Body Example|
|---|
```ruby
{
  "id": 9,
  "part": "front light",
  "category": "lights",
  "price": 1200.0,
  "quantity": 2,
  "client": null
}
```
|Method|Description|URL|
|---|---|--|
|GET| Find all spare parts by client id from registry |http://localhost:8080/api/sparepart/findbyclient/{id}|

|Response Body Example|
|---|
```ruby
{
  "id": 3,
  "username": "user",
  "firstname": "user",
  "lastname": "user",
  "email": "user",
  "password": "$2a$10$Wq8TcIxYsxEJGUFT1VME3O3Q2ne6txIUchwed3SvTnLJZs2dhRc1i",
  "vehicles": [],
  "maintenances": [],
  "spareParts": [
    {
      "id": 10,
      "part": "back wheel",
      "category": "wheels",
      "price": 800.0,
      "quantity": 1
    }
  ]
}
```

|Method|Description|URL|
|---|---|--|
|GET| Find all spare parts by clients username, only the the person with admin role can access this|http://localhost:8080/api/sparepart/findallsparepartsbyclientusername/{nameUser}

|Response Body Example|
|---|
```ruby
[
  {
    "id": 10,
    "part": "back wheel",
    "category": "wheels",
    "price": 800.0,
    "quantity": 1
  }
]
```

# PUT
|Method|Description|URL|
|---|---|--|
|PUT| Update a spare part by id in registry |http://localhost:8080/api/sparepart/update/{id}|
```ruby
{
  "id": 9,
  "part": "back light",
  "category": "lights",
  "price": 1100.0,
  "quantity": 2,
  "client": null
}
```
|Response Body Example|
|---| 
```ruby
{
  "id": 9,
  "part": "back light",
  "category": "lights",
  "price": 1100.0,
  "quantity": 2,
  "client": null
}
```
# DELETE
|Method|Description|URL|
|---|---|--|
|DELETE| Remove an existing spare part with given ID, only person with admin roles can do this |http://localhost:8080/api/sparepart/delete/{id}

|Response Body Example|
|---|
```ruby
Deleted Spare part with id: 9
```


# Maintenance
# POST
|Method|Description|URL|
|---|---|--|
|POST| Create a maintenance category in registry |http://localhost:8080/api/maintenance/create|
```ruby
{
    "type": "Motor CheckUp",
    "price": 800.0,
    "checkInDate": null,
    "checkOutDate": null,
    "jobHistory": "",
    "client":    {	"id": 3,
			"username": "user",
			"firstname": "user",
			"lastname": "user",
			"email": "user",
			"password": "$2a$10$/LUuZbPNeCaRElaWuku3q.qK/yiD/0/n6xNlUWQ/axo1NLv9Av3PC",
			"vehicles": [],
			"maintenances": [],
			"spareParts": []
		}
}
```
|Response Body Exemple|
|---|
```ruby
{
  "id": 12,
  "type": "Motor CheckUp",
  "price": 800.0,
  "checkInDate": null,
  "checkOutDate": null,
  "jobHistory": ""
}
```
# GET 
|Method|Description|URL|
|---|---|--|
|GET| Find all maintenance in registry |http://localhost:8080/api/maintenance/findall

|Response Body Example|
|---|
```ruby
[
  {
    "id": 13,
    "type": "Motor CheckUp",
    "price": 800.0,
    "checkInDate": null,
    "checkOutDate": null,
    "jobHistory": ""
  },
  {
    "id": 15,
    "type": "Tire Change",
    "price": 800.0,
    "checkInDate": null,
    "checkOutDate": null,
    "jobHistory": ""
  }
]
```
|Method|Description|URL|
|---|---|--|
|GET| Find a maintenance by id in registry |http://localhost:8080/api/maintenance/id/{id}|

|Response Body Example|
|---|
```ruby
{
  "id": 13,
  "type": "Motor CheckUp",
  "price": 800.0,
  "checkInDate": null,
  "checkOutDate": null,
  "jobHistory": ""
}
```
|Method|Description|URL|
|---|---|--|
|GET| Find all maintenance by client id from registry |http://localhost:8080/api/maintenance/findbyclient/{id}|

|Response Body Example|
|---|
```ruby
[
  {
    "id": 12,
    "type": "Wheel Storage",
    "price": 800.0,
    "checkInDate": null,
    "checkOutDate": null,
    "jobHistory": ""
  },
  {
    "id": 13,
    "type": "Motor CheckUp",
    "price": 800.0,
    "checkInDate": null,
    "checkOutDate": null,
    "jobHistory": ""
  }
]
```

|Method|Description|URL|
|---|---|--|
|GET| Find all maintenance by clients username |http://localhost:8080/api/sparepart/findallmaintenancesbyclientusername|


|Response Body Example|
|---|
```ruby
[
  {
    "id": 10,
    "type": "Motor CheckUp",
    "price": 800.0,
    "checkInDate": null,
    "checkOutDate": null,
    "jobHistory": ""
  },
  {
    "id": 11,
    "type": "Tire Shift",
    "price": 600.0,
    "checkInDate": null,
    "checkOutDate": null,
    "jobHistory": ""
  }
]
```

# PUT
|Method|Description|URL|
|---|---|--|
|PUT| Update a maintenance by id in registry |http://localhost:8080/api/maintenance/update/{id}|
```ruby
{
  "id": 10,
  "type": "Tire Change",
  "price": 600.0,
  "checkInDate": null,
  "checkOutDate": null,
  "jobHistory": ""
}
```
|Response Body Example|
|---| 
```ruby
{
  "id": 10,
  "type": "Tire Change",
  "price": 600.0,
  "checkInDate": null,
  "checkOutDate": null,
  "jobHistory": ""
}
```
# DELETE
|Method|Description|URL|
|---|---|--|
|DELETE| Remove an existing maintenance with given ID |http://localhost:8080/api/maintenance/delete/{id}

|Response Body Example|
|---|
```ruby
Deleted Maintenance job with id: 10
```


# Vehicle
# POST
|Method|Description|URL|
|---|---|--|
|POST| Create a vehicle to registry |http://localhost:8080/api/vehicle/create|
```ruby
{
    "numberPlate": "XYZ123",
    "maker": "Honda",
    "model": "Infinity",    
    "client":       {
    "id": 3,
    "username": "user",
    "firstname": "user",
    "lastname": "user",
    "email": "user",
    "password": "$2a$10$eX8jNp4thIZvGRJMKaAl7.q3fwhOUcMZqJ6OHkC6D9vsd3CpSG6rm",
    "vehicles": [],
    "maintenances": [],
    "spareParts": []
  }
}
```
|Response Body Exemple|
|---|
```ruby
{
  "id": 11,
  "numberPlate": "XYZ123",
  "maker": "Honda",
  "model": "Infinity"
}
```
# GET 
|Method|Description|URL|
|---|---|--|
|GET| Find all vehicles in registry |http://localhost:8080/api/vehicle/findall

|Response Body Example|
|---|
```ruby
[
  {
    "id": 10,
    "numberPlate": "ABC123",
    "maker": "Toyota",
    "model": "Lexus"
  },
  {
    "id": 11,
    "numberPlate": "XYZ123",
    "maker": "Honda",
    "model": "Infinity"
  }
]
```
|Method|Description|URL|
|---|---|--|
|GET| Find a vehicle by id in registry |http://localhost:8080/api/vehicle/id/{id}|

|Response Body Example|
|---|
```ruby
{
  "id": 10,
  "numberPlate": "ABC123",
  "maker": "Toyota",
  "model": "Levin"
}
```
# PUT
|Method|Description|URL|
|---|---|--|
|PUT| Update a vehicle by id in registry |http://localhost:8080/api/vehicle/update/{id}|
```ruby
{
  
    "id": 10,
    "numberPlate": "ABC123",
    "maker": "Toyota",
    "model": "Levin",
    "client": {
      "id": 5,
      "username": "user2",
      "firstname": "Jn",
      "lastname": "Doe",
      "email": "jhon_doe@google.com",
      "password": "$2a$10$RemrvgmJpD5/7ToE0MSVd.WdhRhoRFgqrGiUtcOrQn5uiHtynr31S",
      "vehicles":[],
    "maintenances": [],
    "spareParts": []
  }
}
```
|Response Body Example|
|---| 
```ruby
{
  "id": 10,
  "numberPlate": "ABC123",
  "maker": "Toyota",
  "model": "Levin"
}
```
# DELETE
|Method|Description|URL|
|---|---|--|
|DELETE| Remove an existing vehicle with given ID |http://localhost:8080/api/vehicle/delete/{id}

|Response Body Example|
|---|
```ruby
Deleted Vehicle with id: 10
```
