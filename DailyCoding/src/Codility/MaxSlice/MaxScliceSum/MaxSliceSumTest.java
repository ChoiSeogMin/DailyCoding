package codility.MaxSlice.MaxScliceSum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxSliceSumTest {

    @Test
    void solution() {

        int[] data1 = {4,-2,-1,3};
        assertEquals(4, MaxSliceSum.solution(data1));

        int[] data2 = {3,2,-6,4,0};
        assertEquals(5, MaxSliceSum.solution(data2));

        int[] data3 = {1,2,3,4,5,6,7,8,9,10};
        assertEquals(55, MaxSliceSum.solution(data3));

        int[] data4 = {3,4,5,1,2,-2,-5,-9,3,6};
        assertEquals(15, MaxSliceSum.solution(data4));

        int[] data5 = {3,4,6,7,1,10,-1,-8,-20,-30,100};
        assertEquals(100,MaxSliceSum.solution(data5));

        int[] data6 = {-10};
        assertEquals(-10,MaxSliceSum.solution(data6));

        int[] data7 = {-5,-8,-13};
        assertEquals(-5,MaxSliceSum.solution(data7));
    }
}