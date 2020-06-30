FROM alpine/git
WORKDIR /app
RUN git clone https://github.com/gogomogolo/number.git

FROM maven:3.5-jdk-8-alpine
WORKDIR /app
COPY --from=0 /app/number /app
RUN mvn install

FROM openjdk:8-jre-alpine
WORKDIR /app
COPY --from=1 /app/target/number-0.0.1-SNAPSHOT.jar /app
EXPOSE 5000
ENTRYPOINT ["sh", "-c"]
CMD ["java -jar number-0.0.1-SNAPSHOT.jar"]
