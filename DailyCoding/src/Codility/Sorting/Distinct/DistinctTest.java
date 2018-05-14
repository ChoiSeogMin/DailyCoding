package codility.Sorting.Distinct;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DistinctTest {

    @Test
    public void 예제테스트() {
        int[] data = {2, 1, 1, 2, 3, 1};
        assertEquals(3,Distinct.solution(data));
    }

    @Test
    public void 예제테스트_같은숫자들() {
        int[] sampleData = {1,1,1,1,1,1,1,1,1,1,1,1,1};
        assertEquals(1,Distinct.solution(sampleData));
    }

    @Test
    public void 예제테스트_여러숫자들() {
        int[] sampleData = {1,2,3,4,4,4,4,5,6,1,2,3,2,3,1,2,3,3,3,4,5,6,7,8,9,99,9};
        assertEquals(10,Distinct.solution(sampleData));
    }
}