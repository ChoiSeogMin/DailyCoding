package codility.Fish;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FishTest {

    @Test
    void solution() {

        int[] A = {4,3,2,1,5};
        int[] B = {0,1,0,0,0};

        assertEquals(2,Fish.solution(A,B));

        int[] C = {1,2,3,4,5};
        int[] D = {0,0,0,0,0};

        assertEquals(5,Fish.solution(C,D));

        int[] E = {5,2,3,1,10};
        int[] F = {0,1,0,0,0};

        assertEquals(4,Fish.solution(E,F));
    }
}