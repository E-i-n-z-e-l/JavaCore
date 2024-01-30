package Task02;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
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
