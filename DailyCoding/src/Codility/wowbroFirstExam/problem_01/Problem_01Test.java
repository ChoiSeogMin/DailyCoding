package codility.wowbroFirstExam.problem_01;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Problem_01Test {

    @Test
    public void test01() {

        assertEquals(7, Problem_01.solution("13 DUP 4 POP 5 DUP + DUP + -"));

        assertEquals(44, Problem_01.solution("13 DUP DUP 5 + + +"));

        assertEquals(-1, Problem_01.solution("3 DUP 5 - -"));

        assertEquals(-1, Problem_01.solution("5 6 + -"));

        assertEquals(10, Problem_01.solution("5 6 DUP 5 + - +"));

        assertEquals(-1, Problem_01.solution("1000000000 6 DUP 5 + - +"));

        assertEquals(-1, Problem_01.solution("-1 -2 DUP 5 + - +"));

        assertEquals(-1, Problem_01.solution("1000000 DUP +"));

        assertEquals(-1, Problem_01.solution("2 3 4 5 POP POP POP POP"));

    }
}