package codility.Dominator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DominatorTest {

    @Test
    void solution() {
        int[] data = {1,2,3,4,1,1,2,2,3,3,4,4,4,3,3,3,3,3,3,3,3,3,3,3};
        assertEquals(2,Dominator.solution(data));

        int[] data2 = {3,4,3,2,3,-1,3,3};
        assertEquals(0,Dominator.solution(data2));

        int[] data3 = {1,1,2,3,4,5};
        assertEquals(-1,Dominator.solution(data3));

        int[] data4 = {1,1,1,3,3,3,1};
        assertEquals(-1,Dominator.solution(data3));

        int[] data5 = {2,2,2,2,2,3};
        assertEquals( 0,Dominator.solution(data5));

        int[] data6 = {1,2,3,4,5,6,7,2,2,2,2,2,2};
        assertEquals(1,Dominator.solution(data6));

        int[] data7 = {1,1};
        assertEquals(0,Dominator.solution(data7));

        int[] data8 = {1};
        assertEquals(0,Dominator.solution(data8));

        int[] data9 = {2,2,2,1,3,3,1,1,2,2};
        assertEquals(-1,Dominator.solution(data9));

        int[] data10 = {1,2};
        assertEquals(-1,Dominator.solution(data10));

        int[] data11 = {1,1,2};
        assertEquals(0,Dominator.solution(data11));
    }
}