# Используем базовый образ с Java
FROM openjdk:17

# Установка рабочей директории внутри контейнера
WORKDIR /app

# Копирование файлов проекта внутрь контейнера
COPY sample /app

# Установка переменной окружения для Java
ENV JAVA_HOME /usr/lib/jvm/java-17-openjdk-amd64

# Компиляция Java-файла
# RUN javac Main.java

# Указываем команду для запуска приложения
CMD ["java", "Main"]