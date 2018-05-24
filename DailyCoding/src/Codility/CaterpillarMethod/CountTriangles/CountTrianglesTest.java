package codility.CaterpillarMethod.CountTriangles;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountTrianglesTest {

    @Test
    public void 예제테스트() {

        int[] data = {10,2,5,1,8,12};
        assertEquals(4,CountTriangles.solution(data));
    }

}