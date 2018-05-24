package codility.CaterpillarMethod.CountTriangles;

import java.util.Arrays;

public class CountTriangles {

    public static int solution(int[] A) {

        return trianglesCount(A);
    }

    private static int trianglesCount(int[] A) {

        int n = A.length;
        int result = 0;
        Arrays.sort(A);

        for(int x = 0; x < A.length; x++) {
            int z = x + 2;
            for(int y = x + 1; y < A.length; y++) {
                while(z < A.length && A[x] + A[y] > A[z]) {
                    z += 1;
                }
                result += z - y - 1;
            }
        }

        return result;
    }
}
