package codility.EquiLeader;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EquiLeaderTest {

    @Test
    void solution() {
        int[] data = {4, 3, 4, 4, 4, 2};
        assertEquals(2,EquiLeader.solution(data));

        int[] data2 = {4,4,2,2,1};
        assertEquals(0, EquiLeader.solution(data2));

        int[] data3 = {1,1,1,1,2,2,2,3,4,1,1,1};
        assertEquals(3,EquiLeader.solution(data3));

        int[] data4 = {1,1,1,2,1,1,1,1,2,2,2,2,3,4,1,1,2,3,2,2,2,1,2,2,3,3,4,2,2,2};
        assertEquals(0,EquiLeader.solution(data4));

        int[] data5 = {1,1,1};
        assertEquals(2,EquiLeader.solution(data5));
    }
}