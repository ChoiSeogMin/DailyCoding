package codility.Arrays.CyclicRotation;

public class CyclicRotation {

    /**
     * rotation개념을 기억해두면 조세퍼스 같은 문제를 풀때 편해 진다.*/
    public static int[] solution(int[] A, int k){

        int realK = k % A.length;
        int[] returnArray = new int[A.length];


        return getReturnArray(A,returnArray,realK);
    }

    private static int[] getReturnArray(int[] A,int[] returnArray,int realK){

        for(int i = 0; i<A.length; i++){

            returnArray[(i+realK)%A.length] = A[i];
        }

        return returnArray;
    }
}
