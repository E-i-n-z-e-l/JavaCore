package taskFour;

/**
 * Задание №4.  Написать программу, читающую и выводящую в содержимое текущей папки.
 */
public class Main {
    public static void main(String[] args) {
        ShowFilesInCurrentDir showFilesInCurrentDir = new ShowFilesInCurrentDir();
        showFilesInCurrentDir.printFiles();
        showFilesInCurrentDir.printAllFilesRecursively();
    }
}
