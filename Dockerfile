FROM maven:3.9.6-eclipse-temurin-21

# set working directory
WORKDIR /app

# copy pom.xml for dependency
COPY pom.xml .
RUN mvn dependency:go-offline

# copy source code
COPY src ./src

# copy data folder
COPY data ./data

# build project DSkipTests for skip tests
RUN mvn package -DskipTests

# run application
CMD ["java", "-jar", "target/payment-txn-calculate-1.0-SNAPSHOT.jar", "data/payments.csv"]
