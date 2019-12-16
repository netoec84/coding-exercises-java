package countingelements;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * L4
 * Find the earliest time when a frog can jump to the other side of a river.
 */
public class FrogRiverOne {

    public int solution(int X, int[] A) {
        int[] countControl = new int[X];
        int totalSteps = 0;

        for (int i = 0; i < A.length; i++) {
            if (countControl[A[i] - 1] <= 0) {
                countControl[A[i] - 1] += 1;
                totalSteps++;

                if (totalSteps == X) {
                    return i;
                }
            } else {
                countControl[A[i] - 1] += 1;
            }
        }

        return -1;
    }

    @Test
    public void exampleCase() {
        int[] A = {1, 3, 1, 4, 2, 3, 5, 4};
        int X = 5;

        assertEquals(6, new FrogRiverOne().solution(X, A));
    }

    @Test
    public void failCase() {
        int[] A = {1, 3, 1, 4, 2, 3, 2, 4};
        int X = 5;

        assertEquals(-1, new FrogRiverOne().solution(X, A));
    }
}
