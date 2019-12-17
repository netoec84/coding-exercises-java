package cdlty.countingelements;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * P => C:L4
 * Find the smallest positive integer that does not occur in a given sequence.
 */
public class MissingInteger {

    public int solution(int[] A) {
        boolean[] isInArray = new boolean[A.length];

        for (int i = 0; i < A.length; i++) {
            if (A[i] < 1 || A[i] > A.length) {
                continue;
            }
            isInArray[A[i] - 1] = true;
        }

        for(int i = 0; i < isInArray.length; i++) {
            if(!isInArray[i]) {
                return i + 1;
            }
        }

        return A.length + 1;
    }

    @Test
    public void negativeNumbers() {
        int[] A = {-1, -3};
        assertEquals(1, new MissingInteger().solution(A));
    }

    @Test
    public void oneNumber() {
        int[] A = {0};
        assertEquals(1, new MissingInteger().solution(A));
    }

    @Test
    public void withoutMissingNumber() {
        int[] A = {1, 2, 3};
        assertEquals(4, new MissingInteger().solution(A));
    }

    @Test
    public void positiveNumbers() {
        int[] A = {1, 3, 6, 4, 1, 2};
        assertEquals(5, new MissingInteger().solution(A));
    }
}
