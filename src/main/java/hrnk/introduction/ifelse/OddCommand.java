package hrnk.introduction.ifelse;

public class OddCommand {

    public String execute() {
        String answer;
        answer = "Weird";
        return answer;
    }

    public boolean match(int number) {
        return number % 2 == 1;
    }

}
