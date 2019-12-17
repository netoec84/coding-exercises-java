package cdlty.countingelements;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * P => C:L4
 * Check whether array A is a permutation.
 */
public class PermCheck {

    public int solution(int[] A) {
        int xor = 0;
        for (int i = 0; i < A.length; i++) {
            xor ^= (i + 1) ^ A[i];
        }
        if (xor == 0) {
            return 1;
        }
        return 0;
    }

    @Test
    public void successCase() {
        int[] A = {4, 1, 3, 2};
        assertEquals(1, new PermCheck().solution(A));
    }

    @Test
    public void failCase() {
        int[] A = {4, 1, 3};
        assertEquals(0, new PermCheck().solution(A));
    }
}
