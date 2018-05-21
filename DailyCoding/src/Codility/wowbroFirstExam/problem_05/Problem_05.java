package codility.wowbroFirstExam.problem_05;

public class Problem_05 {

    public static int solution(int[] A, int K, int L) {
        // write your code in Java SE 8
        if(A.length < K + L)
            return -1;
        int[] sumArrayK = fillArraySumDp(initial(K,A),A,K);
        int[] sumArrayL = fillArraySumDp(initial(L,A),A,L);
        return Math.max(getMaxValue(sumArrayK,sumArrayL,K,L),getMaxValue(sumArrayL,sumArrayK,L,K));
    }

    private static int getMaxValue(int[] sumArrayK, int[] sumArrayL, int K, int L) {
        int maxSum = 0;

        for(int i=K-1; i<sumArrayK.length-L; i++) {
            for(int j=i+L; j<sumArrayL.length; j++) {
                maxSum = Math.max(maxSum,sumArrayK[i]+sumArrayL[j]);
            }
        }
        return maxSum;
    }

    private static int[] initial(int K,int[] A) {
        int[] line = new int[A.length];
        int sum = 0;

        for(int i = 0; i<K; i++) {
            sum += A[i];
        }
        line[K-1] = sum;

        return line;
    }

    private static int[] fillArraySumDp(int[] sumArray, int[] A, int K) {
        for(int i=K; i<A.length; i++) {
            sumArray[i] = sumArray[i-1]-A[i-K]+A[i];
        }
        return sumArray;
    }
}
