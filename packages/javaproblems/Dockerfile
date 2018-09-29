FROM openjdk:alpine as buildserver
COPY . /tmp
WORKDIR /tmp
RUN apk update
RUN apk add maven
RUN mvn package

FROM openjdk:alpine
COPY --from=buildserver /tmp .
RUN java -cp target/javaproblems-1.0-SNAPSHOT.jar com.javaproblems.javaproblems.App 1
