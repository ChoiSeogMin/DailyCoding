package random_question.problem_1208_부분집합의합2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Main_1208_부분집합의합2Test {

    @Test
    void main() {

        int[] a = {1,2,3};

        for(int k:Main_1208_부분집합의합2.getSubset(a)){
            System.out.print(k+" ");
        }
        assertEquals(32,Math.pow(2,5));
    }
}