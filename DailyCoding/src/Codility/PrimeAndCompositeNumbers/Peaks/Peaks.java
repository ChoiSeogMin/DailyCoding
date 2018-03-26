package codility.PrimeAndCompositeNumbers.Peaks;

public class Peaks {

    public static int solution(int[] A) {

        return devidePeak(A,findPeakArray(A));
    }

    public static int[] findPeakArray(int[] A) {

        int[] peakIndexArray = new int[A.length];
        int j = 0;

        for(int i = 1; i < A.length-1; i++) {

            if(A[i-1] < A[i] && A[i] > A[i+1]) {
                peakIndexArray[j++] = i;
            }
        }
        return peakIndexArray;
    }

    public static int devidePeak(int[] A, int[] peakIndexArray){
        //나누기로 찾자.
        for(int divideCnt = 1; divideCnt < A.length; divideCnt++) {
            if(A.length % divideCnt != 0) {//나누어지지 않으면 다음 순서로
                continue;
            }

            int find = 0;
            int groups = A.length/divideCnt;//그룹 사이즈
            boolean ok = true;

            for(int j = 0; j < peakIndexArray.length; j++) {
                if(peakIndexArray[j] == 0) {//마지막이면 나간다.
                    break;
                }

                if(peakIndexArray[j]/divideCnt > find) {
                    ok= false;
                    break;
                }

                if(peakIndexArray[j]/divideCnt == find) {
                    find++;
                }

                if(find != groups) {
                    ok = false;
                }

                if(ok) {
                    return groups;
                }
            }
        }
        return 0;
    }
}
