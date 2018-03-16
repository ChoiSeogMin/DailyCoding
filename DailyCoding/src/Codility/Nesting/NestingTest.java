package codility.Nesting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NestingTest {

    @Test
    void solution() {

        String data = "(()(())())";
        String data2 = "())";
        String data3 = "(";
        String data4 = ")";
        String data5 = "()";
        String data6 = "(((())()()))";
        String data7 = "()()()()()((((())))()()()()()()((()))()))()())(";
        String data8 = "()()()()()()((()))(((())))()((()))";

        assertEquals(1, Nesting.solution(data));
        assertEquals(0, data2);
        assertEquals(0, data3);
        assertEquals(0, data4);
        assertEquals(0, data5);
        assertEquals(1, data6);
        assertEquals(0, data6);
        assertEquals(0, data7);
        assertEquals(1, data8);

    }
}