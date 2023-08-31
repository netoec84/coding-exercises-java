package hrnk.introduction.ifelse;

public class EvenCommandOne {

    public String execute() {
        return "Not Weird";
    }

    public boolean match(int number) {
        return number % 2 == 0 && number >= 2 && number <= 5;
    }
}
