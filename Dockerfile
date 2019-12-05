FROM nimmis/java-centos:openjdk-8-jdk

ARG JDBC_SCHEMA
ENV JDBC_SCHEMA=${DB_SCHEMA}

ARG JDBC_URL
ENV JDBC_URL=${DB_URL}

ARG JDBC_USERNAME
ENV JDBC_USERNAME=${DB_USER}

ARG JDBC_PASSWORD
ENV JDBC_PASSWORD=${DB_PASS}

COPY ./target/user-service-0.0.1-SNAPSHOT.jar /usr/local/src/
WORKDIR /usr/local/src/
CMD ["java", "-jar", "./listing-service-0.0.1-SNAPSHOT.jar"]
