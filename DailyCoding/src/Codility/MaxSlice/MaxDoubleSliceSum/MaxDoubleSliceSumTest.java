package codility.MaxSlice.MaxDoubleSliceSum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxDoubleSliceSumTest {

    @Test
    void solution() {

        int[] data = {3, 2, 6, -1, 4, 5, -1, 2};
        assertEquals(17,MaxDoubleSliceSum.solution(data));

        int[] data2 = {-2, -2, 3, 4, 5, 10, 9, 7, 6, 5, -5};
        assertEquals(49,MaxDoubleSliceSum.solution(data2));

        int[] data3 = {1,2,3,-2,-4,1,2,3};
        assertEquals(6,MaxDoubleSliceSum.solution(data3));
    }
}