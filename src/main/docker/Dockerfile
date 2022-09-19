# syntax=docker/dockerfile:1

FROM openjdk:8-jdk-alpine AS build
WORKDIR /app
COPY . /app
RUN --mount=type=cache,target=/root/.gradle ./gradlew clean build -x test
RUN rm build/libs/*plain.jar
ENV DOCKER_HOST=tcp://host.docker.internal:2375
RUN mkdir -p build/dependency && (cd build/dependency && jar -xf ../libs/*.jar)

FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG DEPENDENCY=/app/build/dependency
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app
EXPOSE 8080
ENTRYPOINT ["java","-cp","app:app/lib/*","com.codeonblue.movies.MoviesApplication"]