package codility.MaxSlice.MaxScliceSum;

public class MaxSliceSum {

    public static int solution(int[] A) {

        return getMaxSliceSum(A);
    }

    private static int getMaxSliceSum(int[] A) {

        int sum = Integer.MIN_VALUE;
        int tempSum = 0;

        //초기화
        int i = -1;
        int j = 0;
        tempSum = A[j];

        //언제까지 돌지 결정
        while(!(i == A.length-1 && j == A.length-1)) {

            sum = Math.max(sum, tempSum);//우선 sum은 계속 저장해 놓는다.

            if(j == A.length-1) {
                i++;
                tempSum = tempSum - A[i];
                continue;
            }

            if(tempSum < 0) {
                if(j == A.length-1) {//만약 j가 마지막항에 도달 했다면, 나간다. 뒤에껄 볼필요가 없어서
                    break;
                } else {//마지막 항이 아니라면 i를 땡긴다. 왜냐면 j를 탐색하면서 최댓값을 찾았을거야.
                    i = j;
                    j++;
                    tempSum = A[j]; //tempSum 초기화 하고 다시
                }
            } else {
                j++;
                tempSum = A[j] + tempSum;
            }
        }

        return sum;
    }
}
