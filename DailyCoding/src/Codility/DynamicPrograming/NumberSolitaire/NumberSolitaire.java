package codility.DynamicPrograming.NumberSolitaire;

import java.util.Arrays;

public class NumberSolitaire {

    public static int solution(int[] A) {
        // write your code in Java SE 8

        int[] d = new int[A.length];
        Arrays.fill(d, Integer.MIN_VALUE);
        d[0] = A[0];

        for(int i = 0; i < A.length; i++) {

            for(int j = 1; j <= 6; j++) {
                if(i-j<0)
                    break;

                d[i] = Math.max(A[i]+d[i-j],d[i]);
            }
        }

        return d[A.length-1];
    }
}
