package codility.Dominator;

public class Dominator {

    public static int solution(int[] A) {

        int dominator = getDominatorNum(A);

        return isMoreThanHalfSize(dominator, A) ? findFirstDominatorIndex(dominator,A) : -1;
    }

    private static int getDominatorNum (int[] A) {

        int size = 0;
        int dominator = 0;

        for (int value:A) {
            if (size == 0) {
                size++;
                dominator = value;
            } else {
                if (value != dominator) {
                    size--;
                } else { //value와 dominator가 같다.
                    size++;
                }
            }
        }

        return dominator;
    }

    private static boolean isMoreThanHalfSize(int dominator, int[] A) {

        int cnt = 0;

        for (int value:A) {
            if (value == dominator) {
               cnt++;
            }
        }
        if (A.length % 2 == 0) {
            return A.length / 2 < cnt;
        }

        return (A.length / 2) + 1 <= cnt;
    }

    private static int findFirstDominatorIndex(int dominator, int[] A) {

        for (int i=0; i<A.length; i++) {
            if (A[i]==dominator) {
                return i;
            }
        }

        return -1;
    }
}
