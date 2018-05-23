package codility.BinarySearchAlgorithm.NailingPlank;

import java.util.Arrays;

public class NailingPlanks {

    public static int solution(int[] A, int[] B, int[] C) {
        // write your code in Java SE 8

        boolean[] isTrueNail = new boolean[A.length];

        int findCount = fillTrueNail(A, B, C, initialData(), isTrueNail);

        return isTrueNailFull(isTrueNail) ? findCount : -1;
    }

    private static boolean isTrueNailFull(boolean[] isTrueNail) {

        for(int i = 0; i < isTrueNail.length; i++) {
            if(isTrueNail[i] == false) {
                return isTrueNail[i];
            }
        }

        return true;
    }

    private static int[] initialData() {
        int[] data = new int[60000];

        for(int i = 1; i<60001; i++) {
            data[i-1] = i;//1부터 ~ 30000으로 채운다.
        }

        return data;
    }

    private static int fillTrueNail(int[] A, int[] B, int[] C, int[] data, boolean[] isTrueNail) {

        int findCount = 0;
        for(int j = 0; j<C.length; j++) {
            for(int i = 0; i<A.length; i++) {
                if (isTrueNail[i] == false) {
                    boolean isFind = binarySearchTree(data, A[i] - 1, B[i] - 1, C[j]);
                    if (isFind) {
                        isTrueNail[i] = true;
                        findCount = j;
                    }
                }
            }
        }

        return findCount + 1;
    }


    public static boolean binarySearchTree(int[] array, int startIndex, int endIndex, int findValue) {

        boolean isFind = false;

        while(startIndex <= endIndex) {

            int mid = (startIndex + endIndex) / 2;

            if(array[mid] == findValue) {
                isFind = true;
                break;
            }

            if(array[mid]>findValue) {
                 endIndex = mid -1;
            } else {
                startIndex = mid + 1;
            }

        }
        return isFind;
    }
}
