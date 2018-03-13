package codility.Brackets;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BracketsTest {

    @Test
    void solution() {

        assertEquals(1,Brackets.solution("{[()()]}"));
        assertEquals(0,Brackets.solution("([)()]"));
        assertEquals(1,Brackets.solution("((((((((()))))))))"));
        assertEquals(0,Brackets.solution("("));
        assertEquals(1, Brackets.solution("[][][][]()()()()(){}{}{}{}"));

    }
}