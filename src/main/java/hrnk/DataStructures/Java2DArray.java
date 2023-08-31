package hrnk.DataStructures;

import java.util.Scanner;

public class Java2DArray {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        scanner.close();

        int max = 0;
        for (int i = 0; i <= 3; i++) {
            int sum = 0;
            for (int j = 0; j <= 3; j++) {
                sum = sum2DArray(arr, i, j);

                if (i == 0 && j == 0) {
                    max = sum;
                }

                if (sum > max) {
                    max = sum;
                }
            }
        }
        System.out.println(max);
    }

    private static int sum2DArray(int[][] arr, int startX, int startY) {
        int total = 0;

        for (int i = 0; i < 3; i++) {
            if (i == 1) {
                total += arr[i + startX][1 + startY];
            } else {
                for (int j = 0; j < 3; j++) {
                    total += arr[i + startX][j + startY];
                }
            }

        }

        return total;
    }
}
