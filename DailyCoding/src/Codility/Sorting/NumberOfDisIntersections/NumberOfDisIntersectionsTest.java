package codility.Sorting.NumberOfDisIntersections;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberOfDisIntersectionsTest {

    @Test
    public void NumberOfDisIntersectionTest() {
        int[] data = {1, 5, 2, 1, 4, 0};
        assertEquals(11, NumberOfDisIntersections.solution(data));
    }


}