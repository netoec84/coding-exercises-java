package hrnk.Strings;

import java.util.Scanner;

public class JavaSubstringComparison {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();

        System.out.println(getSmallestAndLargest(s, k));
    }

    public static String getSmallestAndLargest(String s, int k) {
        java.util.ArrayList<String> subStrings = getSubstrings(s, k);
        java.util.Collections.sort(subStrings);

        String smallest = subStrings.get(0);
        String largest = subStrings.get(subStrings.size() - 1);

        return smallest + "\n" + largest;
    }

    private static java.util.ArrayList<String> getSubstrings(String s, int k) {
        java.util.ArrayList<String> result = new java.util.ArrayList<>();

        for (int i = 0; i <= s.length() - k; i++) {
            result.add(i, s.substring(i, i + k));
        }

        return result;
    }
}
