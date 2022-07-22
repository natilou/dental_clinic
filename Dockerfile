FROM adoptopenjdk/openjdk11:alpine

WORKDIR /app

COPY .mvn/ .mvn

COPY mvnw pom.xml ./

RUN ./mvnw dependency:go-offline

COPY src ./src

RUN ./mvnw install -DskipTests

EXPOSE 8080

CMD ["java", "-jar", "target/clinica-dental-0.0.1-SNAPSHOT.jar"]

#ARG JAR_FILE=target/clinica-dental-0.0.1-SNAPSHOT.jar

#COPY ${JAR_FILE} app.jar

#ENTRYPOINT ["java","-jar","/src/app.jar"]


