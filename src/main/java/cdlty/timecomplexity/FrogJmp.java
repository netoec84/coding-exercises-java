package cdlty.timecomplexity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * P => C:L3
 * Count minimal number of jumps from position X to Y.
 */
public class FrogJmp {

    public int solution(int X, int Y, int D) {
        double distance = Y - X;
        return (int) Math.ceil(distance / (double) D);
    }

    @Test
    public void zeroJump() {
        assertEquals(0, new FrogJmp().solution(10, 10, 1));
    }

    @Test
    public void oneJump() {
        assertEquals(1, new FrogJmp().solution(10, 20, 10));
    }

    @Test
    public void threeJump() {
        assertEquals(3, new FrogJmp().solution(10, 85, 30));
    }
}
