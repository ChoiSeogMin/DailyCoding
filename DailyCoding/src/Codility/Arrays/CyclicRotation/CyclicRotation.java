package codility.Arrays.CyclicRotation;

public class CyclicRotation {

    /**
     * rotation개념을 기억해두면 조세퍼스 같은 문제를 풀때 편해 진다.*/
    public static int[] solution(int[] A, int k) {

        return isNotNullArray(A) ? getRotationArray(A,k) : null;
    }

    private static boolean isNotNullArray(int[] A) {

        return (A != null) ? true : false;
    }

    private static int[] getRotationArray(int[] A,int k) {

        int[] returnArray = new int[A.length];

        for(int i = 0; i<A.length; i++) {

            returnArray[(i+k)%A.length] = A[i];
        }

        return returnArray;
    }
}
