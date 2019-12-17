package unclassified;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Shuffle {

    public int solution(int A) {
        char[] number = String.valueOf(A).toCharArray();
        int limit = number.length / 2;
        char[] result = new char[number.length];

        int right = number.length - 1;
        for (int left = 0; left < limit; left++) {
            result[left * 2] = number[left];
            result[(left * 2) + 1] = number[right];
            right--;
        }

        if (number.length % 2 != 0) {
            result[number.length - 1] = number[limit];
        }

        return Integer.valueOf(String.valueOf(result));
    }

    @Test
    public void exampleCase() {
        int A = 123456;
        int expected = 162534;
        assertEquals(expected, new Shuffle().solution(A));
    }

    @Test
    public void threeNumberCase() {
        int A = 130;
        int expected = 103;
        assertEquals(expected, new Shuffle().solution(A));
    }
}
