package codility.PrimeAndCompositeNumbers.CountFactors;

public class CountFactors {

    public static int solution(int N){

        return getCountFactor(N);
    }

    /**
     * 정확도는 맞았는데.. performance에서 제곱근? 요구해서
     * integer가 아주 클때 4 6이 6에서 4를 판별할때 가까운 수는 2개 밖에 없지만,
     * integer가 (2^10)^3 커지면 4 ~ 6 이 6~ 4로 찾아가는 거 자체가 너무 N이 많아져서
     * performance에서 fail이 난다. 정확도는 맞췄다고 가정해도 Math.sqrt((double)N) + 1 식으로 아예 한정지어줘야 한다. */
    private static int getCountFactor(int N) {

        int resultFactorsCount = 0;

        int preN = 0;
        int preM = 0;

        //언제까지 for문이 돌아야 할까?
        for(int i = 1; i <= Math.sqrt((double)N) + 1; i++) {

            if(N % i == 0) {

                if(preM == i && preN == N / i) { //4 6 다음엔 분명 6 4가 나온다
                    break;
                }

                preN = i;
                preM = N / i;

                resultFactorsCount += 2;

                if(preN == preM) {// 5*5, 6*6, 7*7
                    resultFactorsCount -= 1;
                    break;
                }
            }
        }

        return resultFactorsCount;
    }
}
