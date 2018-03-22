package codility.EquiLeader;

public class EquiLeader {

    public static int solution(int[] A) {

        int dominantNum = getDominantNum(A);

        if(dominantNum != -1){
            return isPossibleDominantNum(A,dominantNum) ? getEquipLeaderNum(A,dominantNum,getDominantCount(A,dominantNum)) : 0;
        }

        return 0;
    }

    private static int getDominantNum(int[] A) {

        int dominant = 0;
        int size = 0;

        for(int i=0; i<A.length; i++) {
            if(size==0) {
                dominant = A[i];
                size++;
            } else {
                if(dominant == A[i]) {
                  size++;
                } else {
                  size--;
                }
            }
        }

        return size > 0 ? dominant : -1;
    }

    private static boolean isPossibleDominantNum(int[] A,int dominant) {

        int cnt = 0;

        for(int k:A) {
            if(k == dominant) {
                cnt++;
            }
        }

        return A.length % 2 == 0 ? cnt > (A.length / 2) : cnt >= (A.length / 2) + 1;
    }

    private static int getDominantCount(int[] A,int dominant) {

        int cnt = 0;

        for(int k:A) {
            if(k == dominant) {
                cnt++;
            }
        }

        return cnt;
    }

    /***
     * 어떻게 이런 생각을 하지? (문제에서 전체 DominantNum 시작해서 Equip을 찾는다는 말인줄은 몰랐다...)
     * (1, 2~n) (1~2, 3~n) 총합을 totalDomiantCnt에서 판별된 갯수만큼 뺀다는 것 자체가..
     * 문제를 제대로 이해하고 풀자.
     */
    private static int getEquipLeaderNum(int[] A, int dominant, int totalDominantCnt){

        int lcnt = 0; //leader appeard until the index.
        int ans  = 0; //the number of equi leaders.
        for (int i = 0; i < A.length; i++) {
            if(A[i] == dominant) {
                lcnt++;
            }
            //check if the current index is a equi leader
            int lelems = i + 1;
            if((lcnt > lelems / 2) && ((totalDominantCnt - lcnt) > (A.length - lelems) / 2)) {
                ans++;
            }
        }

        return ans;
    }
}
