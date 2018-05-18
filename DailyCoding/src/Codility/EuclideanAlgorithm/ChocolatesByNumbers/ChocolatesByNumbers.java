package codility.EuclideanAlgorithm.ChocolatesByNumbers;

public class ChocolatesByNumbers {

    public static int solution(int N, int M) {

        int gcd = gcd(N,M);
        long lcn = lcn(N,M,gcd);
        return (int)(lcn/(long)M);
    }

    public static int gcd(int n, int m) {

        int rest = n % m;
        if(rest == 0) {
            return m;
        }

        return gcd(m,rest);
    }

    public static long lcn(int n, int m, int gcd) {

        long result = (long)((long)n/gcd * (long)m/gcd * (long)gcd);

        return result;
    }
}
