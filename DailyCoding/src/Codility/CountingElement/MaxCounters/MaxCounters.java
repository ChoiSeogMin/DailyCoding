package codility.CountingElement.MaxCounters;

import java.util.Arrays;

public class MaxCounters {

    public static int[] solution(int N, int[] A) {
        int max = 0;
        int tempMax = 0;
        int[] data = new int[N];

        for(int i=0; i<A.length; i++) {

            if(A[i] == N + 1) {
                tempMax = max;
                continue;
            }

            if(data[A[i]-1] <= tempMax) {
                calculOverMaxValue(data, A[i] - 1, tempMax + 1);
                max = getMaxValue(max,data[A[i]-1]);
                continue;
            }

            calculValue(A, data, i);
            max = getMaxValue(max,data[A[i]-1]);
        }

        fillMaxValue(data,tempMax);

        return data;
    }

    private static void calculOverMaxValue(int[] data, int index, int value) {
        data[index] = value;
    }

    private static void calculValue(int[] A, int[] data, int i) {
        data[A[i]-1] += 1;
    }

    private static int getMaxValue(int max,int data) {

        return Math.max(max, data);
    }

    private static void fillMaxValue(int[] data, int resultMax) {
        for(int i = 0; i < data.length; i++) {
            if(data[i] < resultMax)
                calculOverMaxValue(data, i, resultMax);
        }
    }
}
