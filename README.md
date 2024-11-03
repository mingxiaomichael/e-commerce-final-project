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
| Order Service | Cassandra | High write throughput, high availability |
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
CREATE TABLE orders(id int PRIMARY KEY, name text);
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


## Payment Service API Design




## Account Service API Design
