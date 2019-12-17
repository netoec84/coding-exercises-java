package cdlty.iterations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * P => C:L1
 * Find longest sequence of zeros in binary representation of an integer
 */
public class BinaryGap {

    public int solution(int N) {
        char[] binaryNum = Integer.toBinaryString(N).toCharArray();

        int bagLength = 0;
        int startPos = -1;
        for (int position = 0; position < binaryNum.length; position++) {
            if (isZero(binaryNum[position])) {
                continue;
            }

            if (startPos != -1) {
                bagLength = getMaxBagLength(bagLength, startPos, position);
            }
            startPos = position;
        }
        return bagLength;
    }

    private int getMaxBagLength(int actualBagLength, int startPosition, int endPosition) {
        int length = endPosition - 1 - startPosition;
        if (length > actualBagLength) {
            actualBagLength = length;
        }
        return actualBagLength;
    }

    private boolean isZero(int c) {
        return c == '0';
    }

    @Test
    public void binaryGapOfLengthOne() {
        int expected = 1;
        int result = this.solution(10);
        assertEquals(expected, result);
    }

    @Test
    public void binaryGapOfLengthTwo() {
        int expected = 2;
        int result = this.solution(9);
        assertEquals(expected, result);
    }

    @Test
    public void binaryGapOfLengthFour() {
        int expected = 4;
        int result = this.solution(529);
        assertEquals(expected, result);
    }

    @Test
    public void binaryGapOfLengthFive() {
        int expected = 5;
        int result = this.solution(1041);
        assertEquals(expected, result);
    }

    @Test
    public void noBinaryGap() {
        int expected = 0;
        int result = this.solution(32);
        assertEquals(expected, result);
    }

    @Test
    public void noBinaryGapWithOnlyOnes() {
        int expected = 0;
        int result = this.solution(15);
        assertEquals(expected, result);
    }
}
