package codility.TimeComplexity.PermMissingElem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PermMissingElemTest {

    @Test
    void solution() {

        int[] data = {2,3,1,5};
        assertEquals(4,PermMissingElem.solution(data));

        int[] data2 = {1,2,3,4,5,6,7,8,9,11};
        assertEquals(10,PermMissingElem.solution(data2));

        int[] data3 = {1,2,3,4,5,6,8};
        assertEquals(7,PermMissingElem.solution(data3));

        int[] data4 = {2,3,4,5,6};
        assertEquals(1,PermMissingElem.solution(data4));

        int[] data5 = {1,3};
        assertEquals(2,PermMissingElem.solution(data5));
    }
}