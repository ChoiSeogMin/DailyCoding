package codility.PrimeAndCompositeNumbers.Flags;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlagsTest {


    @Test
    void testFindPeakFlag(){

        int[] testData = {1,5,3,4,3,4,1,2,3,4,6,2};
        int[] resultData = {1,3,5,10,0,0,0,0,0,0,0,0};

        assertArrayEquals(resultData,Flags.findPeakFlags(testData));


        int[] testData2 = {10,3,4,5,11,2,3,4,1,2,12,4,5,6,12,313,23,22};
        int[] resultData2 = {4,7,10,15,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        assertArrayEquals(resultData2,Flags.findPeakFlags(testData2));
    }

    @Test
    void solution() {

        int[] data = {1,5,3,4,3,4,1,2,3,4,6,2};
        assertEquals(3,Flags.solution(data));

        int[] data1 = {1,2,3,4,3,2,1,2,3,4,5,6,7,1,2,3,4,1};
        assertEquals(3,Flags.solution(data1));

        int[] data2 = {10,1,10,1,10,1,10,10,10,10,10,10,10,10,10,10,1,10};
        assertEquals(2,Flags.solution(data2));

        int[] data3 = {1,2,3,4,1,2,3,4,1,2,3,1,2,3,4,1,2,3,1};
        assertEquals(3,Flags.solution(data3));

        int[] data4 = {1,10,1};
        assertEquals(1,Flags.solution(data4));
    }
}