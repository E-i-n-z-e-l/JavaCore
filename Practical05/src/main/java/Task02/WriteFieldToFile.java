package Task02;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Предположить, что числа в исходном массиве из 9 элементов имеют диапазон [0, 3], и представляют собой, например,
 * состояния ячеек поля для игры в крестикинолики, где
 * <p></p>
 * 0 – это пустое поле,
 * <p></p>
 * 1 – это поле с крестиком,
 * <p></p>
 * 2 – это поле с ноликом,
 * <p></p>
 * 3 – резервное значение.
 * <p></p>
 * Такое предположение позволит хранить в одном числе типа int всё поле 3х3.
 * <p></p>
 * Записать в файл 9 значений так, чтобы они заняли три байта.
 */
public class WriteFieldToFile {
    public static void main(String[] args) {
        int[] field = {0, 1, 2, 3, 1, 2, 0, 3, 2}; // Пример исходного массива

        try (FileOutputStream fos = new FileOutputStream("field.bin")) {
            int value = 0;
            int bitIndex = 0;

            for (int i = 0; i < field.length; i++) {
                value |= field[i] << bitIndex;
                bitIndex += 2;

                if (bitIndex >= 8) {
                    fos.write(value);
                    value = 0;
                    bitIndex = 0;
                }
            }

            if (bitIndex > 0) {
                fos.write(value);
            }

            System.out.println("Данные успешно записаны в файл!");
        } catch (IOException e) {
            System.out.println("Произошла ошибка при записи данных в файл.");
            e.printStackTrace();
        }
    }
}
