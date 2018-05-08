package codility.SieveOfEratosthenes.CountSemiprimes;

import java.util.*;

public class CountSemiprimes {

    public static int[] solution(int N, int[] P, int[] Q){

        return getResultData(getSemiPrimes(N,getPrimes(N)),P,Q);
    }

    public static int[] getResultData(List<Integer> semiprimes, int[] p, int[] q) {

        int[] resultData = new int[p.length];
        int index = 0;

        for(int i = 0; i < p.length; i++) {
            int count = 0;
            for(int j = 0; j < semiprimes.size(); j++) {
                int data = semiprimes.get(j);

                if (p[i] <= data && data <= q[i]) {
                    count++;
                }
            }
            resultData[i] = count;
        }

        return resultData;
    }

    public static List<Integer> getPrimes(int n) {
        List<Integer> primes = new ArrayList<>();
        boolean primeData[] = new boolean[n+1];

        for(int i = 2; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(j==1 && !primeData[i]) {
                    primes.add(i);
                    continue;
                }

                if(i * j > n) {
                    break;
                }
                primeData[i * j] = true;
            }
        }

        return primes;
    }

    public static List<Integer> getSemiPrimes(int n, List<Integer> primes) {

        List<Integer> semiPrimes = new ArrayList<>();

        for(int i = 0; i < primes.size(); i++) {
            for(int j = i; j < primes.size(); j++) {
                int semiprimes = primes.get(i) * primes.get(j);
                if(n < semiprimes)
                    break;
                semiPrimes.add(semiprimes);
            }
        }
        Collections.sort(semiPrimes);
        return semiPrimes;
    }

}
