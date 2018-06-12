package hackerrank.warmup.DiagonalDifference;

import java.io.*;
import java.util.*;

public class DiagonalDifference {

    // Complete the diagonalDifference function below.
    static int diagonalDifference(int[][] a) {

        int preSum = 0;
        int postSum = 0;

        int l = a.length;
        int k = l-1;
        for(int i = 0; i < l; i++) {
            preSum += a[i][i];
            postSum += a[k][i];
            k--;
        }

        System.out.println(preSum);

        System.out.println(postSum);

        return Math.abs(preSum - postSum);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] a = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] aRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < n; j++) {
                int aItem = Integer.parseInt(aRowItems[j]);
                a[i][j] = aItem;
            }
        }

        int result = diagonalDifference(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
