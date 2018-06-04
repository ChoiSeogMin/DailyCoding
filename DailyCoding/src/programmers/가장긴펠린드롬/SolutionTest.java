package programmers.가장긴펠린드롬;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    public void 가장근펠린드롬() {

        assertEquals(7,Solution.solution("abcdcba"));

        assertEquals(3,Solution.solution("abacde"));

        assertEquals(17,Solution.solution("aaaaaaaaaaaaaaaaa"));

        assertEquals(1,Solution.solution("a"));

        assertEquals(5,Solution.solution("abababcba"));

        assertEquals(9,Solution.solution("abcdedcbabg"));

        assertEquals(0,Solution.solution(""));
    }

}