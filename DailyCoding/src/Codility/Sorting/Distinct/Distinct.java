package codility.Sorting.Distinct;

import java.util.Arrays;

public class Distinct {


    public static int solution(int[] data) {

        int count = 0;
        Arrays.sort(data);
        int preData = Integer.MIN_VALUE;

        for(int i = 0; i < data.length; i++) {
            if(isSamePreData(preData, data, i)) {
                count++;
                preData= data[i];
            }
        }

        return count;
    }

    private static boolean isSamePreData(int preData,int[] data, int i) {
        return preData != data[i];
    }
}
