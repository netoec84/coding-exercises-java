package hrnk.DataStructures;

import java.util.ArrayList;
import java.util.Scanner;

public class JavaArraylist {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int qtyLines = Integer.parseInt(scanner.nextLine());
        ArrayList<int[]> list = new ArrayList<>(qtyLines);

        for (int i = 0; i < qtyLines; i++) {
            list.add(i, parseItemList());
        }

        int qtyQuerys = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < qtyQuerys; i++) {
            System.out.println(query(scanner.nextLine().split(" "), list));
        }
    }

    private static String query(String[] s, ArrayList<int[]> list) {
        int listKey = Integer.parseInt(s[0]) - 1;
        int arrIndex = Integer.parseInt(s[1]) - 1;

        try {
            int[] line = list.get(listKey);
            return String.valueOf(line[arrIndex]);
        } catch (Exception e) {
            return "ERROR!";
        }
    }

    private static int[] parseItemList() {
        String[] line = scanner.nextLine().split(" ");
        int qtyElements = Integer.parseInt(line[0]);
        int[] elements = new int[qtyElements];

        for (int i = 0; i < qtyElements; i++) {
            elements[i] = Integer.parseInt(line[i + 1]);
        }
        return elements;
    }

    private static void print(ArrayList<int[]> list) {
        list.forEach((line) -> {
            for (int i = 0; i < line.length; i++) {
                System.out.print(line[i] + " ");
            }
            System.out.print("\n");
        });
        System.out.print("\n");
    }
}
