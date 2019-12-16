package timecomplexity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * L3
 * Minimize the value |(A[0] + ... + A[P-1]) - (A[P] + ... + A[N-1])|.
 */
public class TapeEquilibrium {

    public int solution(int[] A) {
        int total = 0;
        for (int i = 0; i < A.length; i++) {
            total += A[i];
        }

        int lowerSum = Integer.MAX_VALUE;
        int leftSum = 0;
        for (int i = 0; i < A.length - 1; i++) {
            leftSum += A[i];
            int rightSum = total - leftSum;
            int difference = Math.abs(leftSum - rightSum);

            if(difference < lowerSum) {
                lowerSum = difference;
            }
        }

        return lowerSum;
    }

    @Test
    public void exampleCase() {
        int[] A = {3, 1, 2, 4, 3};
        assertEquals(1, new TapeEquilibrium().solution(A));
    }

    @Test
    public void smallCase() {
        int[] A = {3, 3};
        assertEquals(0, new TapeEquilibrium().solution(A));
    }

    @Test
    public void negativeCase() {
        int[] A = {3, -1};
        assertEquals(4, new TapeEquilibrium().solution(A));
    }
}
