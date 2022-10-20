FROM maven:3.8.4-openjdk-17-slim as build
WORKDIR /app
COPY . .

RUN --mount=type=cache,target=/root/.m2 mvn -f /app/pom.xml -B -U clean package -DskipTests=true -Dorg.slf4j.simpleLogger.log.org.apache.maven.cli.transfer.Slf4jMavenTransferListener=warn
#RUN mvn -B --no-transfer-progress dependency:go-offline
#RUN mvn -B -U package -DskipTests=true -Dorg.slf4j.simpleLogger.log.org.apache.maven.cli.transfer.Slf4jMavenTransferListener=warn

FROM openjdk:17-jdk-slim
WORKDIR /app

COPY --from=build /app/panel-infra/target/panel-infra*.jar /panel-infra.jar

ENTRYPOINT ["java", "-XX:+UseG1GC", "-XX:+UseStringDeduplication", "-jar", "-Dspring.profiles.active=prod", "/panel-infra.jar"]