package hrnk.introduction;

import java.util.Scanner;

public class EndOfFile {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lineNumber = 1;
        while (scanner.hasNext()) {
            System.out.printf("%d %s%n", lineNumber++, scanner.nextLine());
        }
        scanner.close();
    }
}
