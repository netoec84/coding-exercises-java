package hrnk.introduction.BigNumber;

import java.math.BigInteger;
import java.util.Scanner;

public class BigIntegerProblem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigInteger a = new BigInteger(scanner.nextLine());
        BigInteger b = new BigInteger(scanner.nextLine());

        System.out.println(a.add(b));
        System.out.println(a.multiply(b));
    }
}
