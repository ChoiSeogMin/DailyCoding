package codility.Triangle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    @Test
    void solution() {

        int[] data = {10,2,5,1,8,20};
        int[] data2 = {10,50,5,1};
        int[] data3 = {10,20,30,40,50};
        int[] data4 = {Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE};
        assertEquals(1,Triangle.solution(data));

        Triangle.isPossibleTriangle = false;
        assertEquals(0,Triangle.solution(data2));

        Triangle.isPossibleTriangle = false;
        assertEquals(1,Triangle.solution(data3));

        Triangle.isPossibleTriangle = false;
        assertEquals(1,Triangle.solution(data4));
    }

}