package unclassified;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Clock {

    public int solution(String S, String T) {
        int interestingPoints = 0;

        String fromHour = parseTime(S, 0);
        String fromMin = parseTime(S, 1);
        String fromSec = parseTime(S, 2);

        String toHour = parseTime(T, 0);
        String toMin = parseTime(T, 1);
        String toSec = parseTime(T, 2);

        String nowHour = fromHour;
        String nowMin = fromMin;
        String nowSec = fromSec;

        if(S.equals(T)) {
            if (isInterestingPoint(nowHour + nowMin + nowSec)) {
                interestingPoints++;
            }
            return interestingPoints;
        }

        String[] increased;
        do {
            if (isInterestingPoint(nowHour + nowMin + nowSec)) {
                interestingPoints++;
            }

            increased = increase(nowHour, nowMin, nowSec);
            nowHour = zeroFill(increased[0]);
            nowMin = zeroFill(increased[1]);
            nowSec = zeroFill(increased[2]);

        } while (!equal(toHour, toMin, toSec, nowHour, nowMin, nowSec));

        if (isInterestingPoint(nowHour + nowMin + nowSec)) {
            interestingPoints++;
        }

        return interestingPoints;
    }

    public boolean isInterestingPoint(String time) {
        int[] digits = new int[10];
        char[] cDigits = time.toCharArray();
        int index;
        for (int i = 0; i < cDigits.length; i++) {
            index = Integer.valueOf(String.valueOf(cDigits[i]));
            digits[index]++;
        }

        int distinctDigits = 0;
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] != 0) {
                distinctDigits++;
            }
        }

        return distinctDigits <= 2;
    }

    public String zeroFill(String value) {
        if (value.length() < 2) {
            return "0" + value;
        }
        return value;
    }

    public String[] increase(String hour, String min, String sec) {
        String[] now = new String[3];
        int seconds = Integer.valueOf(sec);
        int mins = Integer.valueOf(min);
        int hours = Integer.valueOf(hour);

        if (seconds < 59) {
            seconds++;
        } else {
            seconds = 0;
            mins++;
        }

        if (mins >= 60) {
            mins = 0;
            hours++;
        }

        if (hours >= 60) {
            hours = 0;
            hours++;
        }

        now[0] = String.valueOf(hours);
        now[1] = String.valueOf(mins);
        now[2] = String.valueOf(seconds);

        return now;
    }

    public boolean equal(String toHour, String toMin, String toSec, String nowHour, String nowMin, String nowSec) {
        return (Integer.valueOf(toHour) == Integer.valueOf(nowHour)
                && Integer.valueOf(toMin) == Integer.valueOf(nowMin)
                && Integer.valueOf(toSec) == Integer.valueOf(nowSec));
    }

    public String parseTime(String time, int index) {
        return time.split(":")[index];
    }

    @Test
    public void sameCase() {
        String S = "00:00:00";
        String T = "00:00:00";

        assertEquals(1, new Clock().solution(S, T));
    }

    @Test
    public void exampleThree() {
        String S = "00:00:00";
        String T = "00:00:01";

        assertEquals(2, new Clock().solution(S, T));
    }

    @Test
    public void exampleOne() {
        String S = "15:15:00";
        String T = "15:15:12";

        assertEquals(1, new Clock().solution(S, T));
    }

    @Test
    public void exampleTwo() {
        String S = "22:22:21";
        String T = "22:22:23";

        assertEquals(3, new Clock().solution(S, T));
    }
}
