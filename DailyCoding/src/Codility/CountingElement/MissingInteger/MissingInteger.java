package codility.CountingElement.MissingInteger;

public class MissingInteger {

    public static int solution(int[] A) {

        boolean[] check = new boolean[100000+1];

        serCheckBooleanValues(A, check);
        int value = getMinimumValue(check);

        return value == -1 ? check.length : value;
    }

    private static void serCheckBooleanValues(int[] A, boolean[] check) {
        for(int i = 0; i < A.length; i++) {
            if ((A[i] > 0) && (A[i] <= 100000)) {
                check[A[i]] = true;
            }
        }
    }

    private static int getMinimumValue(boolean[] check) {
        for(int i = 1; i < check.length; i++) {
            if(check[i] == false) {
                return i;
            }
        }
        return -1;
    }
}
