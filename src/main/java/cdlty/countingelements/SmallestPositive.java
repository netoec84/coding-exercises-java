package cdlty.countingelements;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * P => C:Dmo
 */
public class SmallestPositive {

    public int solution(int[] A) {
        int smallestPositive = 1;
        boolean[] exists = new boolean[A.length];

        for (int i = 0; i < A.length; i++) {
            if (A[i] <= 0 || A[i] > A.length) {
                continue;
            }

            exists[A[i] - 1] = true;
        }

        int c = 0;
        for (int i = 0; i < exists.length; i++) {
            if (!exists[i]) {
                smallestPositive = i + 1;
                break;
            } else {
                c++;
            }

        }

        if (c == A.length) {
            smallestPositive = A.length + 1;
        }

        return smallestPositive;
    }

    @Test
    public void exampleCase() {
        int[] A = {1, 3, 6, 4, 1, 2};
        assertEquals(5, new SmallestPositive().solution(A));
    }

    @Test
    public void fillCase() {
        int[] A = {1, 2, 3};
        assertEquals(4, new SmallestPositive().solution(A));
    }
}
