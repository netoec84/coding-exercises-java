package hrnk.Strings;

import java.util.Scanner;

public class JavaStringReverse {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        /* Enter your code here. Print output to STDOUT. */

        int lastPos = A.length() - 1;
        boolean isPal = true;
        for (int i = 0; i < A.length(); i++) {
            String first = A.substring(i, i + 1).toLowerCase();
            String last = A.substring(lastPos, lastPos + 1);
            lastPos--;

            if (!first.equals(last)) {
                isPal = false;
                break;
            }
        }

        if (isPal) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

    }
}
