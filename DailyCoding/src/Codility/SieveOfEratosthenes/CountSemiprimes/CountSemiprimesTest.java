package codility.SieveOfEratosthenes.CountSemiprimes;



import codility.SieveOfEratosthenes.CountSemiprimes.CountSemiprimes;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CountSemiprimesTest {


    @Test
    public void getPrimeTest() {
        List<Integer> primes = CountSemiprimes.getPrimes(26);
        assertThat(primes.size(),is(9));
    }

    @Test
    public void getSemiPrimeTest() {
        List<Integer> primes = CountSemiprimes.getPrimes(26);
        List<Integer> semiPrimes = CountSemiprimes.getSemiPrimes(26,primes);
        assertThat(semiPrimes.size(),is(10));
        System.out.println(semiPrimes);
    }

    @Test
    public void getResultData() {
        List<Integer> primes = CountSemiprimes.getPrimes(26);
        List<Integer> semiPrimes = CountSemiprimes.getSemiPrimes(26,primes);
        assertThat(semiPrimes.size(),is(10));

        int[] P = {1,4,16};
        int[] Q = {26,10,20};
        int[] resultData = CountSemiprimes.getResultData(semiPrimes,P,Q);

        int[] resultTestData = {10,4,0};
        assertArrayEquals(resultTestData,resultData);
        System.out.println(resultData[0]+" "+resultData[1]+" "+resultData[2]);

    }
}