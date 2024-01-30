package Task01;

import java.io.*;
import java.nio.file.*;

/**
 * Задание №1. Написать функцию, создающую резервную копию всех файлов в директории (без поддиректорий) во вновь созданную папку ./backup
 */
public class BackupFiles {
    public static void main(String[] args) {
        String sourceDirectory = "./Task01"; // Путь к исходной директории
        String backupDirectory = "./Task01"; // Путь к директории для создания резервных копий

        try {
            // Создание резервной папки, если её нет
            Files.createDirectories(Paths.get(backupDirectory));

            // Получение списка файлов в исходной директории
            File[] files = new File(sourceDirectory).listFiles();

            // Копирование каждого файла в резервную папку
            assert files != null;
            for (File file : files) {
                if (file.isFile()) {
                    Path sourcePath = Paths.get(file.getAbsolutePath());
                    Path destinationPath = Paths.get(backupDirectory, file.getName());

                    // Копирование файла
                    Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
                }
            }

            System.out.println("Резервные копии файлов созданы успешно!");
        } catch (IOException e) {
            System.out.println("Произошла ошибка при создании резервных копий файлов.");
            e.printStackTrace();
        }
    }
}
