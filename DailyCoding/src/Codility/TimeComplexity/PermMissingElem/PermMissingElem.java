package codility.TimeComplexity.PermMissingElem;

public class PermMissingElem {

    public static int solution(int[] A) {

        return findMissingNum(totalSum(A.length),A);
    }

    private static long totalSum(int k) {

        long result = (long)(k+1) * (long)(k+2) / 2l;

        return result;
    }

    private static int findMissingNum(long totalSum, int[] A) {

        for(int k:A) {
            totalSum -= (long)k;
        }
        return (int)totalSum;
    }
}
