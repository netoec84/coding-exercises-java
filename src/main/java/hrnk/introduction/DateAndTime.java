package hrnk.introduction;

import java.util.Calendar;
import java.util.Scanner;

public class DateAndTime {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String month = in.next();
        String day = in.next();
        String year = in.next();

        System.out.println(getDay(day, month, year));
    }

    private static String getDay(String day, String month, String year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Integer.parseInt(year), Integer.parseInt(month)-1, Integer.parseInt(day));

        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
        switch (calendar.get(Calendar.DAY_OF_WEEK)) {
            case 1:
                return "SUNDAY";
            case 2:
                return "MONDAY";
            case 3:
                return "TUESDAY";
            case 4:
                return "WEDNESDAY";
            case 5:
                return "THURSDAY";
            case 6:
                return "FRIDAY";
            case 7:
                return "SATURDAY";
        }
        return "";
    }
}
