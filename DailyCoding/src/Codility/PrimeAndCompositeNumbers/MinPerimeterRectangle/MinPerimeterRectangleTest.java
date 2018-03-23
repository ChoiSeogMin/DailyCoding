package codility.PrimeAndCompositeNumbers.MinPerimeterRectangle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinPerimeterRectangleTest {

    @Test
    void solution() {

        assertEquals(22,MinPerimeterRectangle.solution(30));
        assertEquals(30,MinPerimeterRectangle.solution(50));
        assertEquals(4,MinPerimeterRectangle.solution(1));
        assertEquals(40000,MinPerimeterRectangle.solution(100000000));

        assertEquals(40,MinPerimeterRectangle.solution(100));
        assertEquals(48,MinPerimeterRectangle.solution(144));
        assertEquals(52,MinPerimeterRectangle.solution(169));
        assertEquals(128,MinPerimeterRectangle.solution(1024));
    }
}