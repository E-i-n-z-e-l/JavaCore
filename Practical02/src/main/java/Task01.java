/**
 * Написать метод, возвращающий количество чётных элементов массива.
 */
public class Task01 {
    public static int searchEvenElementToArray(int[] array) {
        int evenElement = 0;
        for (int j : array) {
            if (j % 2 == 0) {
                evenElement++;
            }
        }
        return evenElement;
    }
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        int count = searchEvenElementToArray(array);
        System.out.println("Четных элементов в массиве: "+ count);
    }
}
