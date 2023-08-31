package hrnk.introduction.ifelse;

import java.util.Scanner;

public class IfElseRefactor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        String answer = "";

        OddCommand oddCommand = new OddCommand();
        EvenCommandOne evenCommandOne = new EvenCommandOne();
        EvenCommandTwo evenCommandTwo = new EvenCommandTwo();
        EvenCommandThree evenCommandThree = new EvenCommandThree();

        if (oddCommand.match(number)) {
            answer = oddCommand.execute();
        } else if (evenCommandOne.match(number)) {
            answer = evenCommandOne.execute();
        } else if (evenCommandTwo.match(number)) {
            answer = evenCommandTwo.execute();
        } else if (evenCommandThree.match(number)) {
            answer = evenCommandThree.execute();
        }

        System.out.println(answer);
    }


}
