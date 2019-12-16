package prefixsums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * L5
 * Find the minimal nucleotide from a range of sequence DNA.
 */
public class GenomicRangeQuery {

    public int[] solution(String S, int[] P, int[] Q) {
        int numberQueries = P.length;
        int[] result = new int[numberQueries];
        char[] sChars = S.toCharArray();

        for (int i = 0; i < numberQueries; i++) {
            for (int j = P[i]; j <= Q[i]; j++) {
                if (result[i] == 0) {
                    result[i] = impactFactor(sChars[j]);
                } else {
                    result[i] = Math.min(result[i], impactFactor(sChars[j]));
                }
            }
        }

        return result;
    }

    public int impactFactor(char c) {
        if (c == 'A') {
            return 1;
        } else if (c == 'C') {
            return 2;
        } else if (c == 'G') {
            return 3;
        }
        return 4;
    }

    @Test
    public void exampleCase() {
        String S = "CAGCCTA";
        int[] P = {2, 5, 0};
        int[] Q = {4, 5, 6};
        int[] expected = {2, 4, 1};

        assertArrayEquals(expected, new GenomicRangeQuery().solution(S, P, Q));
    }

}
