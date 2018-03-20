package codility.MaxSlice.MaxProfit;

public class MaxProfit {

    public static int solution(int[] A){

        return A.length <= 1 ? 0 : getMaxProfit(A);
    }

    private static int getMaxProfit(int[] A){

        int profitGap = Integer.MIN_VALUE;
        int i = 0;
        int j = 1;
        
        while(!(i==A.length-1 && j==A.length-1)){

            if(i == j) {
                j++;
                continue;
            }

            profitGap = Math.max(profitGap,A[j] - A[i]);


            if(j == A.length-1){
                i++;
                continue;
            }

            //profit가 minus면 의미 없는 이익이므로 다른날 산다.
            if(profitGap < 0) {
                i++;
            } else {
                j++;
            }

        }

        return profitGap >= 0 ? profitGap : 0;
    }
}
