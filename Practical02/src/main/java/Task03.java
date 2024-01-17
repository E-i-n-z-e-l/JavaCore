/**
 * Написать функцию, возвращающую истину, если в переданном массиве есть два
 * соседних элемента, с нулевым значением.
 */
public class Task03 {
    public static boolean containsAdjacentZeros(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 0 && arr[i - 1] == 0) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] arrOne = {1, 2, 3, 0, 2, 0};
        int[] arrTwo = {1, 2, 0, 0, 2, 0};

        boolean one = containsAdjacentZeros(arrOne);
        boolean two = containsAdjacentZeros(arrTwo);

        System.out.println(one);
        System.out.println(two);
    }
}
