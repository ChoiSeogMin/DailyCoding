package codility.PrimeAndCompositeNumbers.Flags;

public class Flags {

    public static int solution(int[] A) {
        if(A == null) return 0;
        return getMaxFlagCount(findPeakFlags(A),A);
    }

    public static int[] findPeakFlags(int[] A) {

        int[] returnArray = new int[A.length];
        int j = 0;
        for(int i=1; i<A.length-1; i++) {//j가
            if(A[i]>A[i-1] && A[i]>A[i+1]) {
                returnArray[j++] = i;
            }
        }

        return returnArray;
    }

    public static int getMaxFlagCount(int[] peakIndexArray,int[] A) {

        if(peakIndexArray[0] == 0)
            return 0;

        int flag = 2;
        int flagCount = 1;
        int startFlag = 0;
        int remoteFlag = 1;
        int maxResultFlag = 1;

        while(true) {

            if(peakIndexArray[remoteFlag] == 0) {//끝에 도달 했다.
                if(flagCount != flag) {//만약 flagCount와 falg갯수가 다르면 나간다.
                    break;
                }
            }

            if(peakIndexArray[remoteFlag] - peakIndexArray[startFlag] >= flag) {
                flagCount++;
                startFlag = remoteFlag;
                remoteFlag++;

            } else {
                remoteFlag++;//다음번으로
            }

            if(flagCount == flag) {
                flag++;
                maxResultFlag = Math.max(maxResultFlag,flagCount);
                flagCount = 1;
                startFlag = 0;
                remoteFlag = 1;
            }
        }

        return maxResultFlag;
    }
}
