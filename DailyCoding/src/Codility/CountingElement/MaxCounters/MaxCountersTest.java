package codility.CountingElement.MaxCounters;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class MaxCountersTest {

    @Test
    public void 예제테스트() {
        int[] testArray = {3, 4, 4, 6, 1, 4, 4};
        int[] resultArray = {3, 2, 2, 4, 2};
        assertArrayEquals(MaxCounters.solution(5,testArray),resultArray);
    }

    @Test
    public void 예제테스트2() {
        int[] testArray = {3,3,3,3,3,3};
        int[] resultArray = {0, 0};
        assertArrayEquals(MaxCounters.solution(2,testArray),resultArray);
    }
}