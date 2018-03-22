package codility.PrimeAndCompositeNumbers.MinPerimeterRectangle;

public class MinPerimeterRectangle {

    public static int solution(int N) {

        return getMinPerimeterRectangle(N);
    }

    /***
     * PerimeterRectangle 2 * A * B
     * @param N
     * @return
     */
    private static int getMinPerimeterRectangle(int N) {

        int preB = 0;
        int preA = 0;

        for(int i = 1; i < Math.sqrt((double)N) + 1; i++) {

            if(N % i == 0) {

                if(i == preB) {// 6 4, 4 6
                    break;
                }

                preA = i;
                preB = N / i;

                if(preA == preB) {
                    break;
                }
            }
        }

        return (preB + preA) * 2;
    }
}
