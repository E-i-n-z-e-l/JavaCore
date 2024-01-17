import java.util.Arrays;

/**
 * Написать функцию, возвращающую разницу между самым большим и самым маленьким элементами
 * переданного не пустого массива.
 */
public class Task02 {
    /**
     * Простой поиск.
     * @param array
     * @return
     */
    public static int differenceElement01(int[] array) {
        // Проверяем массив на наличие более двух элементов.
        if (array.length < 2) {
            return 0;
        }
        int minElement = array[0];
        int maxElement = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < minElement) {
                minElement = array[i];
            }
            if (array[i] > maxElement) {
                maxElement = array[i];
            }
        }
        return maxElement - minElement;
    }

    /**
     * Через сортировку массива.
     * @param array
     * @return
     */
    public static int differenceElement02(int[] array) {
        Arrays.sort(array);
        return array[array.length - 1] - array[0];

    }

    public static void main(String[] args) {
        int[] array = {5, 3, 2, 6, 9, 1};

        int difference01 = differenceElement01(array);
        System.out.println(difference01);

        int difference02 = differenceElement02(array);
        System.out.println(difference02);
    }
}
