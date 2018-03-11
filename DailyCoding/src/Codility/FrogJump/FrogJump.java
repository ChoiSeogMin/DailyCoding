package codility.FrogJump;

public class FrogJump {

    //점프 갯수 Count하는 문제.
    //우선 commit
    public static int solution(int X, int Y, int D) {
        int restJumpDistance = Y - X;
        return restJumpDistance % D == 0 ? restJumpDistance / D : (restJumpDistance / D) + 1;
    }
}
