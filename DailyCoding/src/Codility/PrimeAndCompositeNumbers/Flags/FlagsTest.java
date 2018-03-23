package codility.PrimeAndCompositeNumbers.Flags;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlagsTest {

    @Test
    void solution() {

        int[] data = {1,5,3,4,3,4,1,2,3,4,6,2};
        assertEquals(3,Flags.solution(data));

        int[] data1 = {1,2,3,4,3,2,1,2,3,4,5,6,7,1,2,3,4,1};
        assertEquals(3,Flags.solution(data1));

        int[] data2 = {10,1,10,1,10,1,10,10,10,10,10,10,10,10,10,10,1,10};
        assertEquals(1,Flags.solution(data2));

        int[] data3 = {1,2,3,4,1,2,3,4,1,2,3,1,2,3,4,1,2,3,1};
        assertEquals(3,Flags.solution(data3));
    }
}