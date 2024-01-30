package taskOne;

import java.io.*;
import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Задание №1. Создать массив из 9 цифр и записать его в файл, используя поток вывода.
 * <p>
 * Задание №2. Создать массив целых чисел и заполнить его информацией из файла, записанного в предыдущем задании.
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        int[] intArray = new int[]{1, 2, 3, 4, 5, 6, 7, 10};

        String fileName = "taskOne_writeByte";
        // Создается объект DataOutputStream, который будет использоваться для записи данных в файл.
        // Конструктор FileOutputStream(fileName) создает поток вывода данных в файл с именем, указанным в переменной fileName.
        try (DataOutputStream outputStream = new DataOutputStream(new FileOutputStream(fileName))) {
            /*
            Затем следует цикл for, который проходит по каждому числу в массиве intArray. В каждой итерации цикла
            мы вызываем метод writeByte(number), чтобы записать число в файл, а затем вызываем метод writeByte(0),
            чтобы записать нулевой байт после числа.
             */
            for (Integer number : intArray) {
                outputStream.writeByte(number);
                outputStream.writeByte(0); // По сути ставим пробел между числами.
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        /*
        Строка DataInputStream inputStream = new DataInputStream(new FileInputStream(fileName)) создает объект
        DataInputStream, используемый для чтения данных из файла.

        Конструктор FileInputStream(fileName) создает  поток ввода данных из файла с именем, указанным в переменной fileName.
         */
        try (DataInputStream inputStream = new DataInputStream(new FileInputStream(fileName))) {
            /*
            Строка byte[] byteArr = inputStream.readAllBytes() считывает все байты из файла и сохраняет
            их в массив byteArr. Этот метод readAllBytes() читает все содержимое файла и возвращает массив байтов.
             */
            byte[] byteArr = inputStream.readAllBytes();
            /*
            - IntStream.range(0, byteArr.length) создает поток целых чисел от 0 до длины массива byteArr.

            - .map(i -> byteArr[i] & 0xFF) для каждого индекса i массива byteArr берет его значение, преобразует
            его в беззнаковое целое число (диапазон от 0 до 255) с помощью операции побитового AND & с 0xFF.

            - .filter(i -> i != 0) фильтрует значения, оставляя только те, которые не равны 0.

            - .toArray() преобразует значения в массив целых чисел int[].
             */
            int[] arr = IntStream.range(0, byteArr.length).map(i -> byteArr[i] & 0xFF).filter(i -> i != 0).toArray();
            System.out.println(Arrays.toString(arr));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
