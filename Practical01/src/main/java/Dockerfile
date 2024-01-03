# Используем базовый образ с Java
FROM openjdk:20

# Установка рабочей директории внутри контейнера
WORKDIR /app

# Копирование файлов проекта внутрь контейнера
COPY sample /app

# Установка переменной окружения для Java
ENV JAVA_HOME /usr/lib/jvm/java-20-openjdk-amd64

# Компиляция Java-файла
RUN javac Main.java

# Указываем команду для запуска приложения
CMD ["java", "Main"]