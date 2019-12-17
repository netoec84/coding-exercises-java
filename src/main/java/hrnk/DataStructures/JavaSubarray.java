package hrnk.DataStructures;

import java.util.Arrays;
import java.util.Scanner;

public class JavaSubarray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int arraySize = Integer.parseInt(scanner.nextLine());
        String arrayElements = scanner.nextLine();

        int[] items = initArray(arraySize, arrayElements);

        int negativeCounter = 0;
        for (int i = 0; i < items.length; i++) {
            for (int l = 1; l <= items.length - i; l++) {
                int sum = Arrays.stream(Arrays.copyOfRange(items, i, i + l)).sum();
                if (sum < 0) {
                    negativeCounter++;
                }
            }
        }
        System.out.println(negativeCounter);
    }


    private static int[] initArray(int arraySize, String arrayElements) {
        int[] result = new int[arraySize];

        String[] elements = arrayElements.split(" ");
        for (int i = 0; i < elements.length; i++) {
            result[i] = Integer.parseInt(elements[i]);
        }

        return result;
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("\n");
    }
}
