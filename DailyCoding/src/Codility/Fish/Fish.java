package codility.Fish;

public class Fish {

    public static int solution(int[] A,int[] B){

        int rest = A.length;//물고기의 수
        int cnt = 0;

        for (int i=0; i<A.length; i++) {
            if (B[i]==0) {
                continue;
            } else {//1이면
                int j = i;
                while (j+1 < B.length && B[j+1]!= 1) {
                    if (A[j] > A[j+1]) {
                        A[j+1] = A[j];
                        A[j] = -1;
                        j++;
                        i = j;
                    } else { //A[j] < A[j+1]
                        A[j] = -1;
                        i = j + 1;
                        break;
                    }
                }
            }
        }

        for(int k : A){
            if (k != -1) {
                cnt++;
            }
        }
        return cnt;
    }
}
