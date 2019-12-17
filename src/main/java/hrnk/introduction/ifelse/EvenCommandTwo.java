package hrnk.introduction.ifelse;

public class EvenCommandTwo {

    public String execute() {
        return "Weird";
    }

    public boolean match(int number) {
        return number % 2 == 0 && number >= 6 && number <= 20;
    }
}
