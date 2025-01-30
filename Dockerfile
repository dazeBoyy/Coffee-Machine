
FROM openjdk:23-jdk-slim AS build

# Устанавливаем рабочую директорию
WORKDIR /app

# Копируем файлы проекта
COPY pom.xml ./
RUN apt-get update && apt-get install -y maven


# Копируем исходный код
COPY src ./src

# Собираем проект
RUN mvn clean package -DskipTests

FROM openjdk:23-jdk-slim

WORKDIR /app

# Копируем JAR-файл из первого контейнера
COPY --from=build /app/target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]