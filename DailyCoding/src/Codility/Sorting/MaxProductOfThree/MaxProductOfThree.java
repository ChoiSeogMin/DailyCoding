package codility.Sorting.MaxProductOfThree;

import java.util.Arrays;

public class MaxProductOfThree {

    public static int solution(int[] A) {

        Arrays.sort(A);
        int lastIndex = A.length - 1;

        if (isIndexZero(A[lastIndex])) return 0;

        if (isIndexZero(A[lastIndex - 1])) return A[0] * A[1] * A[lastIndex];

        if(isLowZeroTwo(A, lastIndex)) {
            return A[lastIndex - 2] * A[lastIndex - 1] * A[lastIndex];
        }

        if(isLowZero(A[lastIndex - 2])) {
            return A[0] * A[1] * A[lastIndex];
        }


        return Math.max(A[0] * A[1],A[lastIndex-1] * A[lastIndex-2]) * A[lastIndex];
    }

    private static boolean isLowZeroTwo(int[] A, int lastIndex) {
        return A[lastIndex - 2] < 0 && A[lastIndex] < 0;
    }

    private static boolean isLowZero(int i) {
        return i < 0;
    }

    private static boolean isIndexZero(int i) {
        return i == 0;
    }
}
