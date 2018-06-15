package hackerrank.warmup.PlusMinus;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class PlusMinus {

    // Complete the plusMinus function below.
    static void plusMinus(int[] arr) {

        int totalCount = arr.length;

        int zeroCount = 0;
        int plusCount = 0;
        int minusCount = 0;

        for(int data:arr) {

            if(data == 0) {
                zeroCount++;
            }

            if(data > 0) {
                plusCount++;
            }

            if(data < 0) {
                minusCount++;
            }
        }

        System.out.println(Math.round((double)plusCount/(double)totalCount * 1000000.0) / 1000000.0);
        System.out.println(Math.round((double)minusCount/(double)totalCount * 1000000.0) / 1000000.0);
        System.out.println(Math.round((double)zeroCount/(double)totalCount* 1000000.0) / 1000000.0);

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        plusMinus(arr);

        scanner.close();
    }

}
