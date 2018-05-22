package codility.FibonacciNumbers.Ladder;

public class Ladder {

    public static int[] solution(int[] A, int[] B) {

        int L = A.length;
        int[] fib = new int[L+2];
        int[] result = new int[L];
        fib[1] = 1;
        fib[2] = 2;
        setFibonacciNumber(L, fib);
        setResultData(A, B, L, fib, result);

        return result;
    }

    private static void setResultData(int[] A, int[] B, int l, int[] fib, int[] result) {
        for (int i = 0; i < l; i++) {
            result[i] = fib[A[i]] % (1 << B[i]);
        }
    }

    private static void setFibonacciNumber(int l, int[] fib) {
        for (int i = 3; i <= l; i++) {
            // make sure the fibonacci number will not exceed the max integer in java 1<<n = 2^n
            fib[i] = (fib[i-1] + fib[i-2]) % (1 << 30);
        }
    }
}
