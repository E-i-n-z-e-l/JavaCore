package taskThree;

import java.io.*;

public class ReplaceSymbolInFile {
    private String filename;

    public ReplaceSymbolInFile(String filename) {
        this.filename = filename;
    }

    /**
     * Метод replaceChar принимает два параметра: targetCharacter - символ, который нужно заменить,
     * и replacedCharacter - символ, на который нужно его заменить.
     * <p>
     * Процесс выполнения метода replaceChar можно описать следующим образом:
     * <p>
     * Метод открывает файл для чтения (BufferedReader) и создает новый файл с именем "filename_replaced"
     * для записи (BufferedWriter). Затем он последовательно считывает символы из исходного файла, заменяет
     * заданный символ на новый символ и записывает измененные символы в новый файл.
     * В результате получается новый файл, в котором все указанные символы заменены на новые.
     *
     * @param targetCharacter
     * @param replacedCharacter
     */
    public void replaceChar(char targetCharacter, char replacedCharacter) {
        /*
        Внутри метода создаются два объекта:
        BufferedReader reader для чтения из файла.
        BufferedWriter writer для записи в файл.
         */
        try (BufferedReader reader = new BufferedReader(new FileReader(filename)); // поток чтения;
             BufferedWriter writer = new BufferedWriter(new FileWriter(filename + "_replaced"))) { // поток записи;
            /*
            Используется цикл while, который будет выполняться, пока есть данные
            для чтения из файла (reader.ready() возвращает true).
             */
            while (reader.ready()) { // Пока в файле есть что читать, цикл не закончится.
                /*
                Внутри цикла, метод reader.read() считывает текущий символ из файла и сохраняет
                его в переменную currentChar типа char.
                 */
                char currentChar = (char) reader.read();
                /*
                Затем выполняется проверка: если currentChar соответствует символу targetCharacter,
                то вместо него будет записан символ replacedCharacter в файл с помощью метода
                writer.write(replacedCharacter).

                Если currentChar не равен targetCharacter, то он остается неизменным и записывается
                в файл с помощью метода writer.write(currentChar).
                 */
                if (currentChar == targetCharacter) {
                    writer.write(replacedCharacter);
                } else {
                    writer.write(currentChar);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Метод replacePhrase принимает два параметра: actualWord - строку, которую нужно заменить,
     * и target - строку, на которую нужно ее заменить.
     * <p>
     * Процесс выполнения метода replacePhrase можно описать следующим образом:
     * <p>
     * Метод открывает файл для чтения (BufferedReader) и создает новый файл с именем "filename_replaced"
     * для записи (BufferedWriter). Затем он последовательно считывает строки из исходного файла, заменяет
     * указанную строку на новую строку и записывает измененные строки в новый файл.
     * В результате получается новый файл, в котором все указанные строки были заменены на новые.
     * @param actualWord
     * @param target
     */
    public void replacePhrase(String actualWord, String target) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename));
             BufferedWriter writer = new BufferedWriter(new FileWriter(filename + "_replaced"))) {
            while (reader.ready()) {
                /*
                Внутри цикла метод reader.readLine() считывает текущую строку из файла и сохраняет
                ее в переменную currentString типа String.
                 */
                String currentString = reader.readLine();
                /*
                Затем выполняется проверка: если currentString содержит строку
                actualWord (это делается с помощью метода contains()), то вместо actualWord
                будет записана строка target в файл
                с помощью метода writer.write(currentString.replace(actualWord, target)).
                Если currentString не содержит actualWord, то она остается неизменной и записывается
                в файл с помощью метода writer.write(currentString).
                 */
                if (currentString.contains(actualWord)) {
                    writer.write(currentString.replace(actualWord, target));
                } else {
                    writer.write(currentString);
                }
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
