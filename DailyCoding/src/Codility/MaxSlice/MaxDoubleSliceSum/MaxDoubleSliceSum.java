package codility.MaxSlice.MaxDoubleSliceSum;

public class MaxDoubleSliceSum {

    public static int solution(int[] A){

        return getMaxDoubleSliceSum(A);
    }

    public static int getMaxDoubleSliceSum(int[] A) {

        int N = A.length;
        int[] K1 = new int[N];
        int[] K2 = new int[N];

        //i는 0부터 시작하지 않을까?
        //i는 N-2까지만 살피는 걸까?
        //계속 0이랑 Max값을 비교하는 거지?
        //해답은 2개의 슬라이스를 짤라야 되기 때문에
        //1. 0은 default로 자른다고 가정하면 i는 1부터 시작하는게 맞고,
        //2. N-2까지 자르는 이유는 N-1이 세번째 슬라이스의 default인거고
        //3. 0이랑 Max값을 비교하는 이유는 0보다 작아지면 해당 slice를 잘라야 하기 때문이다.
        for(int i = 1; i < N-1; i++) {
            K1[i] = Math.max(K1[i-1] + A[i], 0);
        }

        //이건 반대로 뒤에서부터 1까지 자를거야. (0은 default로 앞에 slice니까 살피지 않는다)
        for(int i = N-2; i > 0; i--) {
            K2[i] = Math.max(K2[i+1] + A[i], 0);
        }

        int max = 0;
        //두 개의 slice 시작 슬라이스 끝의 슬라이스는 찾았다.
        //가운데 슬라이스는 비워야 되니까 N살피면서 자른다.
        for(int i = 1; i < N-1; i++) {
            max = Math.max(max, K1[i-1]+K2[i+1]);
        }

        return max;
    }
}
