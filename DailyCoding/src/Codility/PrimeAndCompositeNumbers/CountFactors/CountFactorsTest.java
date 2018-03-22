package codility.PrimeAndCompositeNumbers.CountFactors;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountFactorsTest {

    @Test
    void solution() {

        assertEquals(8, CountFactors.solution(24));
        assertEquals(9, CountFactors.solution(36));
        assertEquals(1, CountFactors.solution(1));
        assertEquals(9,CountFactors.solution(100));
        assertEquals(10,CountFactors.solution(48));
        assertEquals(6,CountFactors.solution(50));
        assertEquals(6,CountFactors.solution(18));


    }
}
