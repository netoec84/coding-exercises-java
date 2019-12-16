package arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * L2
 * Rotate an array to the right by a given number of steps.
 */
public class CyclicRotation {

    public int[] solution(int[] A, int K) {
        int[] result = A;
        for (int i = 0; i < K; i++) {
            result = rotate(result);
        }
        return result;
    }

    public int[] rotate(int[] arrayToRotate) {
        int size = arrayToRotate.length;

        if(size == 0) {
            return arrayToRotate;
        }

        int[] rotatedArray = new int[size];

        rotatedArray[0] = arrayToRotate[size - 1];
        for (int i = 1; i < size; i++) {
            rotatedArray[i] = arrayToRotate[i - 1];
        }

        return rotatedArray;
    }

    @Test
    public void emptyArray() {
        int[] A = {};
        int[] expected = {};
        int[] result = new CyclicRotation().solution(A, 2);
         assertArrayEquals(expected, result);
    }

    @Test
    public void zeroRotate() {
        int[] A = {3, 8, 9, 7, 6};
        int[] expected = {3, 8, 9, 7, 6};
        int[] result = new CyclicRotation().solution(A, 0);
        assertArrayEquals(expected, result);
    }

    @Test
    public void caseOne() {
        int[] A = {3, 8, 9, 7, 6};
        int[] expected = {6, 3, 8, 9, 7};
        int[] result = new CyclicRotation().solution(A, 1);
        assertArrayEquals(expected, result);
    }

    @Test
    public void caseTwo() {
        int[] A = {3, 8, 9, 7, 6};
        int[] expected = {9, 7, 6, 3, 8};
        int[] result = new CyclicRotation().solution(A, 3);
        assertArrayEquals(expected, result);
    }

    @Test
    public void caseThree() {
        int[] A = {0, 0, 0};
        int[] expected = {0, 0, 0};
        int[] result = new CyclicRotation().solution(A, 1);
        assertArrayEquals(expected, result);
    }

    @Test
    public void caseFour() {
        int[] A = {1, 2, 3, 4};
        int[] expected = {1, 2, 3, 4};
        int[] result = new CyclicRotation().solution(A, 4);
        assertArrayEquals(expected, result);
    }
}
