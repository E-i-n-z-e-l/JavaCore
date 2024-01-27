package taskOne;

import java.io.*;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("seminar five");
        int[] intArray = new int[]{1, 2, 3, 4, 5, 6, 7, 10};

        String fileName = "taskOne_writeByte";

        try (DataOutputStream outputStream = new DataOutputStream(new FileOutputStream(fileName))) {
            for (Integer number : intArray) {
                outputStream.writeByte(number);
                outputStream.writeByte(0);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (DataInputStream inputStream = new DataInputStream(new FileInputStream(fileName))) {
            byte[] byteArr = inputStream.readAllBytes();

            int[] arr = IntStream.range(0, byteArr.length).map(i -> byteArr[i] & 0xFF).filter(i -> i != 0).toArray();
            System.out.println(Arrays.toString(arr));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
