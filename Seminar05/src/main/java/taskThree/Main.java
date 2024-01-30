package taskThree;

/**
 * Задание №3. Написать программу, заменяющую указанный символ в текстовом файле на пробел, сохраняющую получившийся
 * текст в новый файл.
 */
public class Main {
    public static void main(String[] args) {
        ReplaceSymbolInFile replaceSymbolInFile = new ReplaceSymbolInFile("taskOne");
        replaceSymbolInFile.replaceChar(' ', '!');
        replaceSymbolInFile.replacePhrase("2, 3,", "999");

        ReplaceSymbolInFile replacePhraseInFile = new ReplaceSymbolInFile("bigFile.txt");
        long timeStart = System.currentTimeMillis();
        replacePhraseInFile.replacePhrase("Spring", "Winter");
        System.out.println("replace time: " + ((System.currentTimeMillis() - timeStart) / 1000.0));
    }
}
