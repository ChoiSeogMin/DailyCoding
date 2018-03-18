package codility.EquiLeader;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EquiLeaderTest {

    @Test
    void solution() {
        int[] data = {4, 3, 4, 4, 4, 2};
        assertEquals(2,EquiLeader.solution(data));
    }
}