package hackerrank.warmup.BirthdayCakeCandle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BirthdayCakeCandleTest {

    @Test
    public void birthdayCakeCandlesTest() {
        int[] data = {3, 2, 1, 3};
        assertEquals(2,BirthdayCakeCandle.birthdayCakeCandles(data));
    }

    @Test
    public void birthdayCakeCandlesTest2() {
        int[] data = {3, 8, 1, 3, 4, 4, 5, 5, 6, 4, 6, 3, 8, 4, 5, 8};
        assertEquals(3,BirthdayCakeCandle.birthdayCakeCandles(data));
    }


}