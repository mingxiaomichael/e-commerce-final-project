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




## Order Service API Design




## Payment Service API Design




## Account Service API Design
