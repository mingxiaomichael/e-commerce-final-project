# E-Commerce-Final-Project

## Service IP Setting

Item Service: 127.0.0.1:8080

Order Service: 127.0.0.1:8081

Payment Service: 127.0.0.1:8082

Account Service: 127.0.0.1:8083

## Database Selection

| **Service** | **Database** | **Reason** |
|-------------|--------------|------------|
| Item Service | MongoDB | High Read Performance, flexible schema |
| Order Service | Cassandra | High write throughput, high scalability |
| Payment Service | MySQL | Transactional |
| Account Service | MySQL | Fixed data model |

### Database Port Mapping

Item Service (MongoDB): 27017

Order Service (Cassandra): 9042

Payment Service (MySQL): 3306

Account Service (MySQL): 3307

## Item Service

### MongoDB connection

Docker MongoDB container:
```
docker run --name {name} -e MONGO_INITDB_ROOT_USERNAME={name} -e MONGO_INITDB_ROOT_PASSWORD={password} -p 27017:27017 -d mongo:latest
```

In docker exec:
```
mongosh -u {name} -p {password}
```

In MongoDB: Create `itemDB` database, and then create `items` collection.
```
use itemDB;
db.createCollection("items");
```

(Optional) Manually create a instance:
```
db.items.insertOne({
     name: "Sample Item",
     description: "This is a sample item",
     unit_price: 19.99,
     quantity: 100,
     createdAt: new Date()
});
```

Add dependency:
```
<dependency>
    <groupId>org.springframework.data</groupId>
    <artifactId>spring-data-mongodb</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

In `application.properties` file:
```
spring.application.name=item
server.port=8080

spring.data.mongodb.uri=mongodb://root:root@localhost:27017/itemDB?authSource=admin
```
Or
```
spring.application.name=item
server.port=8080

spring.data.mongodb.uri=jdbc:mongodb://localhost:27017/itemDB
spring.data.mongodb.host=127.0.0.1
spring.data.mongodb.port=27017
spring.data.mongodb.username=root
spring.data.mongodb.password=root
spring.data.mongodb.database=itemDB
spring.data.mongodb.authentication-database = admin
```

### Item Service API Design

Create item: 

POST: `http://localhost:8080/items`

Request body:
```
{
    
    "itemName": "iPhone",
    "price": 999.99,
    "category": "electronics",
    "purchaseLimit": 10,
    "inventory": 1000
}

{
    "itemName": "iPad",
    "price": 888.88,
    "category": "electronics",
    "purchaseLimit": 10,
    "inventory": 0
}

{
    "itemID": 1,
    "itemName": "Airpod",
    "price": 888.88,
    "category": "electronics",
    "purchaseLimit": 10,
    "inventory": 1000
}
```

Find item by itemID
GET `http://localhost:8080/items/itemID/1`


Find item by inventory:

GET: `http://localhost:8080/items`


Find item by name with inventory:

GET: `http://localhost:8080/items/name/inventory/iPhone`

Find item by purchase limit 


GET `http://localhost:8080/items/purchaseLimit/5`
GET `http://localhost:8080/items/purchaseLimit/20`

Find item by inventory more than purchase limit

GET `inventory`

Update item: 

PUT: `http://localhost:8080/items/iPhone`

Request body:
```
{
    "itemName": "iPhone",
    "price": 100,
    "category": "electronics",
    "purchaseLimit": 10,
    "inventory": 1000
}
```

Delete item: 

DELETE: `http://localhost:8080/items/iPhone`




## Order Service

### Cassandra connection

Docker Cassandra container:
```
docker run --name order -e CASSANDRA_USER={username} -e CASSANDRA_PASSWORD={password} -p 9042:9042 -d cassandra
```
In docker exec:
```
cqlsh -u {username} -p {password}
```
Create a keyspace (database):
```
CREATE KEYSPACE orderDB WITH replication = {'class': 'SimpleStrategy', 'replication_factor': 1};
```
Create a table:
```
use orderDB;
CREATE TABLE orders (
    userId BIGINT,
    orderId BIGINT,
    orderName TEXT,
    itemId LIST<BIGINT>,
    orderStatus TEXT,
    PRIMARY KEY ((userId, orderId))
);
```

In `application.properties` file:
```
spring.application.name=order
server.port=8081

spring.cassandra.contact-points=127.0.0.1
spring.cassandra.port=9042
spring.cassandra.keyspace-name=orderdb
spring.cassandra.username=root
spring.cassandra.password=root
spring.cassandra.local-datacenter=datacenter1
spring.cassandra.authenticator=PasswordAuthenticator
```


## Payment Service

### MySQL connection

Docker MySQL container:
```
docker run --name {name} -e MYSQL_ROOT_PASSWORD={password} -p 3306:3306 -d mysql
```

In docker exec:
```
mysql -u {name} -p {password}
```

In MySQL: Create `paymentDB` database.
```
CREATE DATABASE paymentDB;
```

### Payment Service API Design


Create payment method:

POST: `http://localhost:8082/payment/createPaymentMethod`


Request body:
```
{
    "orderId": 1,
    "paymentCard": "1234123412341234",
    "cardExpiration": "12/25",
    "cvv": 123,
    "billingAddress": "1809 Willowtree Lane",
    "zip": 48105
}
```

Response:
```
{
    "orderId": 1,
    "paymentStatus": "UNPAID",
    "paymentCard": "1234123412341234",
    "billingAddress": "1809 Willowtree Lane",
    "zip": 48105
}
```


Make payment:

POST: `http://localhost:8082/payment/makePayment`

Request body:
```
{
    "orderId": 1,
    "paymentCard": "1234123412341234",
    "cardExpiration": "12/25",
    "cvv": 123,
    "billingAddress": "1809 Willowtree Lane",
    "zip": 48105
}
```

Response:
```
{
    "userId": 1,
    "orderId": 1,
    "paymentStatus": "PAID"
}
// This means user 1 PAID order 1 successfully.
```






## Account Service

### MySQL connection

Docker MySQL container:
```
docker run --name {name} -e MYSQL_ROOT_PASSWORD={password} -p 3307:3306 -d mysql
```

In docker exec:
```
mysql -u {name} -p {password}
```

In MySQL: Create `accountDB` database.
```
CREATE DATABASE accountDB;
```

Add dependency:
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>

<!-- MySQL Connector -->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.32</version> <!-- Make sure to use the latest version -->
</dependency>

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>

<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-api</artifactId>
    <version>0.11.2</version>
</dependency>
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-impl</artifactId>
    <version>0.11.2</version>
    <scope>runtime</scope>
</dependency>
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-jackson</artifactId>
    <version>0.11.2</version>
    <scope>runtime</scope>
</dependency>
```

In `application.properties` file:
```
spring.application.name=account

server.port=8083

#spring.datasource.url=jdbc:mysql://localhost:3307/accountDB?allowPublicKeyRetrieval=true&useSSL=false
spring.datasource.url=jdbc:mysql://localhost:3307/accountDB
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

How to setup JWT in Spring Boot:

1. JwtUtil (Utility Class)
Purpose: Manages token creation, validation, and extraction.
Key Methods.
2. JwtFilter (Custom Filter)
Purpose: Intercepts incoming requests to check for a valid JWT token in the Authorization header, verifies it, and sets authentication information in the security context.
3. WebSecurityConfig (Configuration Class)
Purpose: Configures Spring Security to use JWT-based authentication and applies security settings across endpoints.

### Account Service API Design

Register: 

POST: `http://localhost:8083/account/register`

Request body:
```
{
    "userEmail": "xxx@gmail.com",
    "password": "00000000"
}
```
```
{
    "userEmail": "yyy@gmail.com",
    "password": "11111111"
}
```

Response:
```
{
    "userId": 2,
    "userEmail": "yyy@gmail.com",
    "password": "$2a$10$qvIWIwA9lyesrLEt/XOInu/qvR7e00UKWFUynf.HWIwTmrCI1nBx."
}
```

Login:

POST: `http://localhost:8083/account/login`

Request Body:
```
{
    "userEmail": "yyy@gmail.com",
    "password": "11111111"
}
```

Response:
```
{
    "userId": 2,
    "userEmail": "yyy@gmail.com",
    "jwtToken": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ5eXlAZ21haWwuY29tIiwidXNlcklkIjoyLCJpYXQiOjE3MzA4NjYxNjQsImV4cCI6MTczMTQ3MDk2NH0.FKeCviFpb_Abj1qen-ftD2fql3eCLPjWS_-yqV2_8yU"
}
```