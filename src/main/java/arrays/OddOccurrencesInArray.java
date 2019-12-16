package arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * L2
 * Find value that occurs in odd number of elements.
 */
public class OddOccurrencesInArray {

    public int solution(int[] A) {
        int xor = 0;
        for (int i = 0; i < A.length; i++) {
            xor ^= A[i];
        }

        return xor;
    }

    @Test
    public void oneElement() {
        int[] A = {3};
        assertEquals(3, new OddOccurrencesInArray().solution(A));
    }

    @Test
    public void threeElement() {
        int[] A = {5, 5, 1};
        assertEquals(1, new OddOccurrencesInArray().solution(A));
    }

    @Test
    public void fiveElements() {
        int[] A = {5, 5, 3, 7, 7};
        assertEquals(3, new OddOccurrencesInArray().solution(A));
    }

    @Test
    public void nineElements() {
        int[] A = {9, 3, 9, 3, 9, 7, 9};
        assertEquals(7, new OddOccurrencesInArray().solution(A));
    }
}
