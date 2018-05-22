package codility.FibonacciNumbers.Ladder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {


    @Test
    public void 예제테스트() {
        int[] A = {4,4,5,5,1};
        int[] B = {3,2,4,3,1};
        int[] result = {5,1,8,0,1};
        assertArrayEquals(result,Ladder.solution(A,B));
    }

    @Test
    public void 예제테스트2() {
        int[] A = {2,4,5,5,1};
        int[] B = {3,2,4,5,1};
        int[] result = {2,1,8,8,1};
        assertArrayEquals(result,Ladder.solution(A,B));
    }

}