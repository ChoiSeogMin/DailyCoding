package codility.MaxSlice.MaxProfit;

public class MaxProfit {

    public static int solution(int[] A){

        return isVaildLengthArray(A) ? getMaxProfit(A) : 0;
    }


    private static boolean isVaildLengthArray(int[] A){

        return A.length > 1 ? true : false;
    }
    /**
     * 언제 i를 움직이고 언제 j를 움직일까?
     * 기본적으로 gap이 마이너스면 조건에 필요 없으므로, i(이전 포인트)를 옮기고
     * 플러스면(결과값)에 영향을 주므로, j를 움직인다. (이후 gap까지 확인 필요)
     * 종이에 적어보고 한단위씩 따져볼때가 도움이 될때가 많다.
     * @param A
     * @return
     */
    private static int getMaxProfit(int[] A) {

        int profitGap = Integer.MIN_VALUE;
        int tempProfitGap = 0;
        int i = 0;
        int j = 1;

        while(!(i==A.length-1 && j==A.length-1)) {

            if(i == j) {
                j++;
                continue;
            }

            tempProfitGap = A[j] - A[i];
            profitGap = Math.max(profitGap,A[j] - A[i]);


            if(j == A.length-1) {
                i++;
                continue;
            }

            //profit가 minus면 의미 없는 이익이므로 다른날 산다.
            if(tempProfitGap < 0) {
                i++;
            } else {
                j++;
            }

        }
        return profitGap >= 0 ? profitGap : 0;
    }
}
