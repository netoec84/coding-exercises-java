package cdlty.unclassified;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * P => C:XMN
 */
public class LargestInteger {

    public int solution(int[] A) {
        int largestInteger = 0;

        int compare, absValue;
        for (int i = 0; i < A.length; i++) {
            compare = A[i];
            for (int j = i + 1; j < A.length; j++) {
                if (largestInteger >= Math.abs(A[j])) {
                    continue;
                }

                if (compare + A[j] == 0) {
                    absValue = Math.abs(compare);
                    if (largestInteger < absValue) {
                        largestInteger = absValue;
                    }
                }
            }
        }

        return largestInteger;
    }

    @Test
    public void exampleOne() {
        int A[] = {3, 2, -2, 5, - 3};
        assertEquals(3, new LargestInteger().solution(A));
    }

    @Test
    public void noSuch() {
        int[] A = {1, 2, 3, - 4};
        assertEquals(0, new LargestInteger().solution(A));
    }
}
