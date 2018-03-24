package codility.Arrays.CyclicRotation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CyclicRotationTest {

    @Test
    void solution() {

        int[] data = {3,8,9,7,6};
        int[] resultData = {9,7,6,3,8};
        assertArrayEquals(resultData,CyclicRotation.solution(data,3));

        int[] data2 = {1,2,3,4,5,6};
        int[] resultData2 = {4,5,6,1,2,3};
        assertArrayEquals(resultData2,CyclicRotation.solution(data2,3));

        int[] data3 = {1,2,3,4,5,6,7,8,9};
        int[] resultData3 = {9,1,2,3,4,5,6,7,8};
        assertArrayEquals(resultData3,CyclicRotation.solution(data3,100));

        int[] data4 = {1,2,3,4,5,6,7,8,9,10};
        int[] resultData4 = {7,8,9,10,1,2,3,4,5,6};
        assertArrayEquals(resultData4,CyclicRotation.solution(data4,144));

        int[] data5 = {1,2,3,4,5,6};
        int[] resultData5 = {3,4,5,6,1,2};
        assertArrayEquals(resultData5,CyclicRotation.solution(data5,76));

        int[] data6 = {0,0};
        int[] resultData6 = {0,0};
        assertArrayEquals(resultData6,CyclicRotation.solution(data6,1134));
    }
}