package codility.MaxSlice.MaxDoubleSliceSum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxDoubleSliceSumTest {

    @Test
    void solution() {

        int[] data = {3, 2, 6, -1, 4, 5, -1, 2};
        assertEquals(17,MaxDoubleSliceSum.solution(data));
    }
}