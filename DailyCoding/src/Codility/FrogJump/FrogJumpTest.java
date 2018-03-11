package codility.FrogJump;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FrogJumpTest {

    @Test
    void solution() {
        assertEquals(3,FrogJump.solution(10,85,30));
        assertEquals(4,FrogJump.solution(0,Integer.MAX_VALUE,Integer.MAX_VALUE/3));
        assertEquals(1,FrogJump.solution(0,Integer.MAX_VALUE, Integer.MAX_VALUE));
        assertEquals(10, FrogJump.solution(0,127,13));

    }
}