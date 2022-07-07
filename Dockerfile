FROM openjdk:11-jdk as base
ENV APP_HOME = /app
WORKDIR $APP_HOME
COPY *.gradle gradle.* gradlew ./
COPY gradle ./gradle

COPY src ./src

FROM base as test
RUN ./gradlew build || return 0

FROM base as build
RUN ./gradlew build || return 0

FROM base as development
CMD ["./gradlew", "bootRun", "-Dspring-boot.run.jvmArguments='-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:8000'"]

FROM openjdk:11-jre-slim as production
EXPOSE 8080

COPY --from=build /sportsdata-*.jar /app.jar
CMD ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/sportsdata.jar"]
