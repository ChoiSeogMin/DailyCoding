package codility.wowbroFirstExam.problem_04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem_04Test {

    @Test
    public void test04() {
        assertEquals(5, Problem_04.solution(1,1,2,3));
        assertEquals(8, Problem_04.solution(2,4,2,4));
        assertEquals(628, Problem_04.solution(-5,-12,10,7));
        assertEquals(200000000, Problem_04.solution(-5000,-5000,5000,5000));
    }
}