package codility.PrimeAndCompositeNumbers.Peaks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PeaksTest {

    @Test
    void solution() {
        int[] data = {1,2,3,4,3,4,1,2,3,4,6,2};
        assertEquals(3, PeaksAnswer.solution(data));

        int[] data2 = {1,2,3,1,6,2,3,2,4,3};
        assertEquals(2, PeaksAnswer.solution(data2));
    }

    @Test
    void findPeakTest() {

        int[] data = {1,2,3,4,3,4,1,2,3,4,6,2};
        int[] resultData = {3,5,10,0,0,0,0,0,0,0,0,0};

        assertArrayEquals(resultData,Peaks.findPeakArray(data));
    }
}