package codility.wowbroFirstExam.problem_05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem_05Test {

    @Test
    public void test05() {

        int[] A = {6,1,4,6,3,2,7,4};
        assertEquals(24, Problem_05.solution(A,3,2));

        int[] B = {2,2,3,3,3};
        assertEquals(13, Problem_05.solution(B,3,2));

        int[] C = {5,2};
        assertEquals(7, Problem_05.solution(C,1,1));

        int[] D = {1,2,3,1,2,3,6,7,1,2,3,1};
        assertEquals(-1, Problem_05.solution(D,4,9));

        int[] Q = {1,2,3,1,2,3,6,7,1,2,8,1};
        assertEquals(29, Problem_05.solution(Q,5,2));

        int[] E = {19,10,15};
        assertEquals(44, Problem_05.solution(E,1,2));

        int[] F = {19,10,15,30,20,15,999,542,44,32,15,65,98,123,45,21,75,510,999,541,10000};
        assertEquals(11541, Problem_05.solution(F,2,1));

    }

}