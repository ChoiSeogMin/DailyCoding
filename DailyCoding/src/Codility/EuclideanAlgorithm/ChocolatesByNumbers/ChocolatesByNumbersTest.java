package codility.EuclideanAlgorithm.ChocolatesByNumbers;

import jdk.jfr.StackTrace;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChocolatesByNumbersTest {

    @Test
    public void 예제테스트() {

        int n = 10;
        int m = 4;

        assertEquals(5,ChocolatesByNumbers.solution(10,4));
    }

    @Test
    public void 맥스테스트() {

        int n = 1000000000;
        int m = 5000;

        assertEquals(200000,ChocolatesByNumbers.solution(n,m));
    }



    @Test
    public void 최대공약수테스트() {

        assertEquals(2,ChocolatesByNumbers.gcd(10,2));
        assertEquals(3,ChocolatesByNumbers.gcd(21,3));
        assertEquals(4,ChocolatesByNumbers.gcd(16,4));
        assertEquals(3,ChocolatesByNumbers.gcd(12,3));
        assertEquals(2,ChocolatesByNumbers.gcd(8,2));
        assertEquals(2,ChocolatesByNumbers.gcd(4,10));
        System.out.println(ChocolatesByNumbers.gcd(1000000000,90000000));
    }

}