# mediastore
SpringBoot-REST application that provide operations for media rental services
mvn spring-boot:run






POSTMAN URIs
--create rental
POST localhost:8080/api/rentals
JSON
{
  "rental_date": 1116980979000,
  "inventory_id": 1853,
  "customer_id": 436,
  "return_date": 1117686399000,
  "staff_id": 2,
  "last_update": 1140019253000
}

--get rental
GET localhost:8080/api/rentals/2

--update rental
JSON
PUT localhost:8080/api/rentals/2
{
  "rental_id": 2,
  "rental_date": 1335205543511,
  "inventory_id": 55,
  "customer_id": 66,
  "return_date": 1335205543511,
  "staff_id": 77,
  "last_update": 1335205543511
}

--delete rental
Type JSON
DELETE localhost:8080/api/rentals/2

--getCustomerByEmail
GET localhost:8080/api/customers/email?email=MARY.SMITH@sakilacustomer.org

--getCustomersByCity
GET localhost:8080/api/customers/city?city=Abha

--getRentalsByCustomer
GET localhost:8080/api/rentals/customer/1?page=1
