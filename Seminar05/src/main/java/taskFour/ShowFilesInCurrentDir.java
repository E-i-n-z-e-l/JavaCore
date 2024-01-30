package taskFour;

import java.io.File;
import java.util.Objects;

public class ShowFilesInCurrentDir {
    /**
     * Метод printFiles() отвечает за вывод всех файлов и папок в текущей директории.
     * Код начинается со строки File file = new File(".");, где создается новый объект типа File,
     * который представляет текущую директорию (обычно это директория, в которой находится запущенная программа).
     * Затем, с помощью метода listFiles(), мы получаем массив всех файлов и папок в этой директории.
     */
    public void printFiles() {
        File file = new File(".");
        /*
        Далее идет цикл for по массиву полученных файлов и папок. Внутри цикла мы выводим имена каждого файла
        или папки с помощью метода getName(), и используем System.out.println() для вывода имени на консоль.

        Таким образом, метод printFiles() просто выводит на консоль имена всех файлов и папок в текущей директории.
         */
        for (File f : Objects.requireNonNull(file.listFiles())) {
            System.out.println(f.getName());
        }
    }

    /**
     * Метод printAllFilesRecursively() отвечает за рекурсивный вывод всех файлов и папок в текущей директории
     * и ее поддиректориях. Сначала мы снова создаем объект типа File для текущей директории.
     * Затем, аналогично методу printFiles(), мы получаем массив всех файлов и папок в текущей директории.
     * <p></p>
     * Затем идет цикл for по этому массиву. Внутри цикла мы вызываем вспомогательный приватный метод diveDeep(),
     * передавая в него текущий файл и уровень глубины (начиная с 0).
     */
    public void printAllFilesRecursively() {
        File file = new File(".");
        int level = 0;
        for (File f : Objects.requireNonNull(file.listFiles())) {
            diveDeep(f, level);
        }
    }

    /**
     * Метод diveDeep() является приватным и рекурсивным. Он принимает два параметра: текущий файл (тип File) и
     * уровень глубины (тип int).
     * <p></p>
     * Внутри метода diveDeep() сначала проверяется, является ли текущий файл файлом или папкой с помощью
     * метода isFile(). Если текущий файл является файлом, то выводится его имя с отступом, в зависимости
     * от уровня глубины.
     * <p></p>
     * Если же текущий файл является папкой, то сначала выводится имя папки с отступом, в зависимости от
     * уровня глубины, после чего следует двоеточие. Затем происходит еще один цикл for, в котором мы проходимся
     * по всем файлам и папкам внутри текущей папки. Для каждого файла или папки вызывается рекурсивно метод
     * diveDeep() с увеличенным уровнем глубины на 1.
     * <p></p>
     * В результате, метод diveDeep() рекурсивно выводит имена всех файлов и папок в текущей директории и ее
     * поддиректориях, с отступами, соответствующими уровню глубины. Это дает структурированный иерархический
     * вид всех файлов и папок в директории.
     * @param currentFile
     * @param level
     */
    private void diveDeep(File currentFile, int level) {
        if (currentFile.isFile()) {
            System.out.println("  ".repeat(level) + currentFile.getName());
        } else {
            System.out.println("  ".repeat(level) + currentFile.getName().toLowerCase() + ":");
            for (File file : Objects.requireNonNull(currentFile.listFiles())) {
                diveDeep(file, ++level);
            }
        }
    }

    private void diveDeepFromTimofey(File currentFile, int level) {
        if (currentFile.isFile()) {
            System.out.println("    ".repeat(level) + currentFile.getName());
        } else {
            System.out.println("    ".repeat(level) + currentFile.getName().toLowerCase() + ":");
            ++level;
            for (File file : Objects.requireNonNull(currentFile.listFiles())) {
                diveDeepFromTimofey(file, level);
            }
        }
    }
}
