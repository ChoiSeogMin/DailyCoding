package codility.MaxSlice.MaxProfit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxProfitTest {

    @Test
    void solution() {

        int[] data6 = {8,9,3,6,1,2};
        assertEquals(3,MaxProfit.solution(data6));

        int[] data = {23171,21011,21123,21366,21013,21367};
        assertEquals(356,MaxProfit.solution(data));

        int[] data2 = {1,2,3,4,5,6,7,8,9,10};
        assertEquals(9,MaxProfit.solution(data2));

        int[] data3 = {1,2,3,4,20,7,8,9,15};
        assertEquals(19, MaxProfit.solution(data3));

        int[] data4 = {10,50,20,40,50,10,20,100,30,40,50,60};
        assertEquals(90, MaxProfit.solution(data4));

        int[] data5 = {100,90,80,20,30,10,30,40,20,20,30,40};
        assertEquals(30,MaxProfit.solution(data5));

    }
}