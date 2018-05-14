package codility.Sorting.MaxProductOfThree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxProductOfThreeTest {

    @Test
    public void 예제테스트() {
        int[] data = {-3, 1, 2, -2, 5, 6};
        assertEquals(60,MaxProductOfThree.solution(data));
    }

    @Test
    public void 음수테스트() {
        int[] data = {-1,-3,-4,-5,-15,-20};
        assertEquals(-12,MaxProductOfThree.solution(data));
    }

    @Test
    public void 음수양수복합테스트_0() {
        int[] data = {-10, -8, -6, -3, 2, 1};
        assertEquals(160,MaxProductOfThree.solution(data));
    }

    @Test
    public void 양수음수복합테스트_1() {
        int[] data = {1,0,-1,-1};
        assertEquals(1,MaxProductOfThree.solution(data));
    }


    @Test
    public void 양수음수복합테스트_2() {
        int[] data = {10,15,1,0,-1,-1,-20,-30};
        assertEquals(9000,MaxProductOfThree.solution(data));
    }

    @Test
    public void 양수테스트() {
        int[] data = {1, 2, 3, 4, 5, 6};
        assertEquals(120,MaxProductOfThree.solution(data));
    }

}