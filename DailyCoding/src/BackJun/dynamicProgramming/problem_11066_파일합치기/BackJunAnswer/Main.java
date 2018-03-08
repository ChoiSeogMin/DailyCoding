package dynamicProgramming.problem_11066_파일합치기.BackJunAnswer;

import java.util.*;
import java.io.*;
public class Main {
    public static int go(int[] a, int[] s, int[][] d, int i, int j) {
        if (i == j) {
            return 0;
        }
        if (d[i][j] != -1) {
            return d[i][j];
        }
        int ans = -1;  //처음 들어왔을 때구나. 
        for (int k=i; k<=j-1; k++) {
            int temp = go(a, s, d, i, k) + go(a, s, d, k+1, j) + s[j] - s[i-1];
            if (ans == -1 || ans > temp) {
                ans = temp;
            }
        }
        d[i][j] = ans;
        return ans;
    }
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.valueOf(bf.readLine());//처음 갯수를 읽는다.
        while (t-- > 0) {//갯수 줄인다.
            int n = Integer.valueOf(bf.readLine());//행의 갯수 읽어서
            String[] nums = bf.readLine().split(" ");//nums배열을 뽑는다.
            int[] a = new int[n+1];//왜 n+1이지..
            int[] s = new int[n+1];//왜 n+1일까
            int[][] d = new int[n+1][n+1];//memoryzation
            for (int i=1; i<=n; i++) {
                a[i] = Integer.valueOf(nums[i-1]);
                s[i] = s[i-1] + a[i];
                Arrays.fill(d[i], -1);
            }
            System.out.println(go(a, s, d, 1, n));
        }
    }
}
