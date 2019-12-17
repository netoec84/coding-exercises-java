package cdlty.countingelements;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * P => C:L4
 * Calculate the values of counters after applying all alternating operations:
 * increase counter by 1; set value of all counters to current maximum.
 */
public class MaxCounters {

    public int[] solution(int N, int[] A) {
        int[] counter = new int[N];
        int maxValue = 0;

        int counterIndex;
        for (int i = 0; i < A.length; i++) {
            counterIndex = A[i] - 1;
            if (A[i] <= N) {
                counter[counterIndex] += 1;
                if (maxValue < counter[counterIndex]) {
                    maxValue = counter[counterIndex];
                }
            } else {
                counter = maxCounter(counter, maxValue);
            }
        }

        return counter;
    }

    public int[] maxCounter(int[] counter, int maxValue) {
        for (int i = 0; i < counter.length; i++) {
            counter[i] = maxValue;
        }
        return counter;
    }

    @Test
    public void exampleCase() {
        int N = 5;
        int[] A = {3, 4, 4, 6, 1, 4, 4};
        int[] expected = {3, 2, 2, 4, 2};

        assertArrayEquals(expected, new MaxCounters().solution(N, A));
    }
}
