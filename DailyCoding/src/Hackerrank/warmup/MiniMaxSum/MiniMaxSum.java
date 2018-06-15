package hackerrank.warmup.MiniMaxSum;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MiniMaxSum {
    //문제를 잘 읽자.
    // Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) {

        long maxSum = Long.MIN_VALUE;
        long minSum = Long.MAX_VALUE;

        for(int i = 0; i < arr.length; i++) {

            long sum = 0;

            for(int j = 0; j < arr.length; j++) {
                if(j != i)
                    sum += arr[j];
            }

            maxSum = Math.max(sum,maxSum);
            minSum = Math.min(sum,minSum);
        }

        System.out.println(minSum + " " + maxSum);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[5];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }
}
