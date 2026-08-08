FROM maven:3.9.9-eclipse-temurin-17 AS build

ARG MODULE
WORKDIR /workspace

COPY pom.xml .
COPY account/pom.xml account/pom.xml
COPY item/pom.xml item/pom.xml
COPY order/pom.xml order/pom.xml
COPY payment/pom.xml payment/pom.xml

COPY account/src account/src
COPY item/src item/src
COPY order/src order/src
COPY payment/src payment/src

RUN mvn -pl item,payment,account clean install -DskipTests -Dspring-boot.repackage.skip=true && \
    mvn -pl "${MODULE}" clean package -DskipTests && \
    cp "${MODULE}/target/"*.jar /app.jar

FROM eclipse-temurin:17-jre

WORKDIR /app
COPY --from=build /app.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
