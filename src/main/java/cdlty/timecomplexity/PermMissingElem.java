package cdlty.timecomplexity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * P => C:L3
 * Find the missing element in a given permutation.
 */
public class PermMissingElem {

    public int solution(int[] A) {
        int expectedSum = 0;
        int realSum = 0;
        int adder = 1;

        for (int i = 0; i < A.length; i++) {
            expectedSum += adder++;
            realSum += A[i];
        }
        expectedSum += adder++;
        return expectedSum - realSum;
    }

    @Test
    public void smallArray() {
        int[] A = {1, 3};
        assertEquals(2, new PermMissingElem().solution(A));
    }

    @Test
    public void exampleArray() {
        int[] A = {2, 3, 5, 1};
        assertEquals(4, new PermMissingElem().solution(A));
    }
}
