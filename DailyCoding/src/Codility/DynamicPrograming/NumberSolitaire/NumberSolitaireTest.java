package codility.DynamicPrograming.NumberSolitaire;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberSolitaireTest {

    @Test
    public void 예제테스트() {
        int[] data = {1,-2,0,9,-1,-2};

        assertEquals(8,NumberSolitaire.solution(data));
    }

    @Test
    public void 예제테스트2() {
        int[] data = {1,-20,0,-45,2,5};

        assertEquals(8,NumberSolitaire.solution(data));
    }

    @Test
    public void 예제테스트3() {
        int[] data = {1,-2};

        assertEquals(-1,NumberSolitaire.solution(data));
    }

    @Test
    public void 예제테스트4() {
        int[] data = {-1,-2};

        assertEquals(-3,NumberSolitaire.solution(data));
    }

    @Test
    public void 예제테스트5() {
        int[] data = {1,2,3,-1,-2,-4,2};

        assertEquals(8,NumberSolitaire.solution(data));
    }

    @Test
    public void 예제테스트6() {
        int[] data = {-1,-2,-3,-2,-3,-1,-5,-4,4,5,-10,-11,7,8,-5,3};

        assertEquals(25,NumberSolitaire.solution(data));
    }

    @Test
    public void 예제테스트7() {
        int[] data = {-1,-2};

        assertEquals(-3,NumberSolitaire.solution(data));
    }
}