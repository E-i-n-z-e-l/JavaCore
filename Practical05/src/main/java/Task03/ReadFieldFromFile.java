package Task03;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.DataInputStream;

/**
 * Задание №3. Прочитать числа из файла, полученного в результате выполнения второго задания.
 */
public class ReadFieldFromFile {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("field.bin");
             DataInputStream dis = new DataInputStream(fis)) {

            while (dis.available() > 0) {
                int value = dis.read();

                // Обработка прочитанного числа
                int[] field = convertToField(value);
                for (int i = 0; i < field.length; i++) {
                    System.out.print(field[i] + " ");
                }
            }

        } catch (IOException e) {
            System.out.println("Произошла ошибка при чтении данных из файла.");
            e.printStackTrace();
        }
    }

    // Преобразование прочитанного числа в массив значений поля
    private static int[] convertToField(int value) {
        int[] field = new int[9];
        for (int i = 0; i < field.length; i++) {
            field[i] = (value >> (i * 2)) & 0b11;
        }
        return field;
    }
}
