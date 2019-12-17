package hrnk.DataStructures;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaList {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int initSize = Integer.parseInt(scanner.nextLine());
        List<Integer> list = parseElements(scanner.nextLine().split(" "), initSize);
        int qtyQuerys = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < qtyQuerys; i++) {
            processQuery(list);
        }
        printList(list);
    }

    private static void processQuery(List<Integer> list) {
        String action = scanner.nextLine();
        String params = scanner.nextLine();

        if ("Insert".equals(action)) {
            String[] splitedParams = params.split(" ");
            int key = Integer.parseInt(splitedParams[0]);
            int value = Integer.parseInt(splitedParams[1]);
            list.add(key, value);
        } else if ("Delete".equals(action)) {
            int key = Integer.parseInt(params);
            list.remove(key);
        }
    }

    private static void printList(List<Integer> list) {
        list.forEach((value) -> {
            System.out.print(value + " ");
        });
        System.out.print("\n");
    }

    private static List<Integer> parseElements(String[] s, int initialSize) {
        List<Integer> list = new ArrayList<>(initialSize);

        for (int i = 0; i < s.length; i++) {
            list.add(i, Integer.parseInt(s[i]));
        }

        return list;
    }
}
