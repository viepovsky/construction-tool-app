FROM eclipse-temurin:17-alpine
WORKDIR /app
COPY . .
RUN chmod +x gradlew
RUN ./gradlew dependencies
CMD ./gradlew bootRun