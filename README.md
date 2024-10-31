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

Order Service (Cassandra): 7000

Payment Service (MySQL): 3306

Account Service (MySQL): 3307

## Item Service API Design

Add dependency:
```
<dependency>
    <groupId>org.springframework.data</groupId>
    <artifactId>spring-data-mongodb</artifactId>
</dependency>
```

Config:
```
spring.application.name=item
server.port=8080

spring.data.mongodb.uri=mongodb://root:root@localhost:27017/itemDB
spring.data.mongodb.port=27017
spring.data.mongodb.database=itemDB
spring.data.mongodb.username=root
spring.data.mongodb.password=root
```

Create a docker container:
```
docker run --name {name} -e MONGO_INITDB_ROOT_USERNAME={name} -e MONGO_INITDB_ROOT_PASSWORD={password} -p 27017:27017 -d mongo:latest
```

In docker exec:
```
mongosh -u {name} -p {password}
```

In mongoDB:
```
use itemDB
db.createCollection("items")
```

Manually create a instance:
```
db.items.insertOne({
     name: "Sample Item",
     description: "This is a sample item",
     unit_price: 19.99,
     quantity: 100,
     createdAt: new Date()
})
```


## Order Service API Design




## Payment Service API Design




## Account Service API Design
