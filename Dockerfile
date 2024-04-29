FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app

ENV POSTGRES_URL "jdbc:postgresql://localhost:5431/sis-323"
ENV POSTGRES_USER "postgres"
ENV POSTGRES_PASSWORD "admin"
ENV DISCOVERY_SERVER_URL "http://localhost:8761/eureka/"

ENTRYPOINT ["java","-cp","app:app/lib/*","com.notification.msnotification.MsNotificationApplicationKt"]