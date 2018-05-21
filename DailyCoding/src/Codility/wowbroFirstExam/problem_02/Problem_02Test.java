package codility.wowbroFirstExam.problem_02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem_02Test {

    @Test
    public void test02() {
        assertEquals(4, Problem_02.solution("A586QK","JJ653K"));
        assertEquals(4, Problem_02.solution("23A84Q","K2Q25J"));
        assertEquals(0, Problem_02.solution("23456789","23456789"));

    }

}