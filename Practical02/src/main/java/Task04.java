import java.util.Arrays;

/**
 * Требуется написать метод, принимающий на вход размеры двумерного массива и выводящий массив
 * в виде инкременированной цепочки чисел, идущих по спирали.
 */
public class Task04 {
    public static void main(String[] args) {
        int[][] matrix = new int[6][6];

        for (int i = 0; i <matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        int value = 1; // начальное значение для заполнения массива

        int rowStart = 0; // начальная строка
        int rowEnd = matrix.length - 1; // конечная строка
        int colStart = 0; // начальный столбец
        int colEnd = matrix[0].length - 1; // конечный столбец

        while (rowStart <= rowEnd && colStart <= colEnd) {
            // Заполняем верхнюю строку
            for (int i = colStart; i <= colEnd; i++) {
                matrix[rowStart][i] = value;
                value++;
            }
            rowStart++;

            // Заполняем правый столбец
            for (int i = rowStart; i <= rowEnd; i++) {
                matrix[i][colEnd] = value;
                value++;
            }
            colEnd--;

            // Заполняем нижнюю строку
            if (rowStart <= rowEnd) {
                for (int i = colEnd; i >= colStart; i--) {
                    matrix[rowEnd][i] = value;
                    value++;
                }
                rowEnd--;
            }

            // Заполняем левый столбец
            if (colStart <= colEnd) {
                for (int i = rowEnd; i >= rowStart; i--) {
                    matrix[i][colStart] = value;
                    value++;
                }
                colStart++;
            }
        }

        // Выводим массив на консоль
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
