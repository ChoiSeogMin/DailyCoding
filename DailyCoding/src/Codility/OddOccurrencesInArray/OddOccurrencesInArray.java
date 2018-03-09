package codility;


/***
 * 홀수가 들어 있는 배열을 딱 한 번만 세서, 쌍이 없는 홀수를 판별하는 문제.
 * 시간복잡도는 N에 공간복잡도는 1에 요구했기 때문에
 * 한 변수 잡아서 Array 훑으라는 말인데
 * 어쨌든 곱셈도 덧셈도 다 해봤는데, 안돼서 비트마스큰가 하다가, exculsive OR가 있었다.
 * exculsive OR는 짝수는 비크마스크 기준 짝수개는 0으로 수렴하고, 홀수 개 경우에는
 * 비트가 존재, 남아있는 비트로 수를 판별하는 거라서 홀,짝 판별할때 많이 쓰인다고 합니다.
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
