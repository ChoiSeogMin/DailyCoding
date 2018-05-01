package codility.CountingElement.MaxCounters;

import java.util.Arrays;

public class MaxCounters {

    public static int[] solution(int N, int[] A) {
        int decisionMax = 0;
        int[] data = new int[N];

        for(int i=0; i<A.length; i++) {

            if(A[i] == N+1) {
                fillMaxValue(data,decisionMax);
                continue;
            }
            decisionMax = decisionDataCounter(N,data,i,A,decisionMax);
        }

        return data;
    }

    private static void fillMaxValue(int[] data, int resultMax) {
        for(int i = 0; i < data.length; i++) {
            data[i] = resultMax;
        }
    }

    private static int getMaxValue(int[] data) {
        int max = 0;
        for(int m:data) {
            max = Math.max(m,max);
        }
        return max;
    }

    private static int decisionDataCounter(int N, int[] data, int j, int[] A, int decisionMax) {
        if(1 <= A[j] && A[j] <= N) {
            data[A[j] - 1] += 1;
        }

        return Math.max(data[A[j] - 1],decisionMax);
    }
}
