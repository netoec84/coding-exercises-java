package hrnk.introduction;

import java.util.Scanner;

public class IfElse {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        String answer = "";

        if (number % 2 == 1) {
            answer = "Weird";
        } else {
            if (number >= 2 && number <= 5) {
                answer = "Not Weird";
            } else if (number >= 6 && number <= 20) {
                answer = "Weird";
            } else if (number > 20) {
                answer = "Not Weird";
            }
        }

        System.out.println(answer);
    }
}
