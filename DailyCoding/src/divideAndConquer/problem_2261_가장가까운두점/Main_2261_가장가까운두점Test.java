package divideAndConquer.problem_2261_가장가까운두점;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class Main_2261_가장가까운두점Test {

    @Test
    void main() {
        long time = System.currentTimeMillis();
        for(int i=0; i<1000000000l; i++){
            int j=0;
        }

        System.out.println(System.currentTimeMillis() - time);

    }

    @Test
    void testGetDistance(){

        ArrayList<Pair> array = new ArrayList<>();
        array.add(new Pair(1,3));
        array.add(new Pair(2,5));
        array.add(new Pair(3,9));
        array.add(new Pair(8,5));

        assertEquals(5,Main_2261_가장가까운두점.getDistance(0,4,array));
    }
}