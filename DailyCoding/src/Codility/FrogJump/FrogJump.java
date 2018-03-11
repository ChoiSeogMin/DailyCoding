package codility.FrogJump;

public class FrogJump {

    //점프 갯수 Count하는 문제.
    //우선 commit
    public static int solution(int X, int Y, int D) {
        // write your code in Java SE 8

        int restJumpDistance = Y - X;

        if(restJumpDistance % D == 0){
            return restJumpDistance / D;
        }
        return (restJumpDistance / D) + 1;

    }
}
