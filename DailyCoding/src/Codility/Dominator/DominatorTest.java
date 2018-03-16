package codility.Dominator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DominatorTest {

    @Test
    void solution() {
        int[] data = {1,2,3,4,1,1,2,2,3,3,4,4,4};
        assertEquals(3,Dominator.solution(data));
    }
}