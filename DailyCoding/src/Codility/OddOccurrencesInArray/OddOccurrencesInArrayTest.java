package codility;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OddOccurrencesInArrayTest {

    @Test
    void solution() {

        int[] A = {9,3,9,3,9,7,9};
        int[] testArrayB = {1,1,1,1,1,1,1,1,1,1,1,1,5};
        int[] testArrayC = {1,3,3,3,3,5,5};
        int[] testArrayD = {1000000001,1000000001,3};
        int[] testArrayE = {1,3,3,3,3,3,3,1,1,1,10001,10001,9999,9999,12345,12345,12345};

        assertEquals(7,OddOccurrencesInArray.solution(A));
        assertEquals(5,OddOccurrencesInArray.solution(testArrayB));
        assertEquals(1,OddOccurrencesInArray.solution(testArrayC));
        assertEquals(3,OddOccurrencesInArray.solution(testArrayD));
        assertEquals(12345,OddOccurrencesInArray.solution(testArrayE));

        assertEquals(0, 3^3);
        assertEquals(1,2^3); // (10 ^ 11) = 01
        assertEquals(3,7^4); // (111,100) = 011

    }
}