package codility;


/***
 * 홀수가 들어 있는 배열을 딱 한 번만 세서, 쌍이 없는 홀수를 판별하는 문제.
 * 시간복잡도는 N에 공간복잡도는 1에 요구했기 때문에
 * 한 변수 잡아서 Array 훑으라는 말인데
 * 어쨌든 곱셈도 덧셈도 다 해봤는데, 안돼서 비트마스큰가 하다가, exculsive OR가 있었다.
 *
 */
public class OddOccurrencesInArray {

    public static int solution(int[] A){

        int center = 0;

        for(int k: A){
            center ^= k;
        }

        return center;
    }
}
