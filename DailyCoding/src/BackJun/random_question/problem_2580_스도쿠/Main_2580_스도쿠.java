package random_question.problem_2580_스도쿠;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_2580_스도쿠 {


    private static int currentRow;
    private static int currentCol;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] data = new int[10][10];

        for (int i = 1; i < 10; i++) {
            int j = 1;
            for (String s:br.readLine().split(" ")) {
                data[i][j++] = Integer.valueOf(s);
            }
        }

        fill(data);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                sb.append(data[i][j]+" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    public static boolean isEmpty(int[][] data){

        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                if (data[i][j]==0) {
                    currentRow = i;
                    currentCol = j;
                    return false;
                }
            }
        }
        return true;
    }

    /***
     * 백트랙킹이라고 하는데.. 재귀적인 방법을 생각해야 된다.
     * 재귀를 특히나 어려워 하는건 과정을 종이에 적어보지 않기 때문이다.
     * 원리를 듣고, 정답소스를 보면 이해가 가지만 그 전에 사고하기는 어렵다.
     * 과정을 종이에 적어보면서 반복되는 과정을 재귀에 넣는다라고
     * 사고 할줄 알아야 하는데..
     * 이번 달 내 다시 풀어 봐야 된다.
     * @param data
     * @return
     */
    public static boolean fill(int[][] data) {
        int r = 0;
        int c = 0;

        if(isEmpty(data)){
            return true;
        }

        r = currentRow;
        c = currentCol;

        for(int n = 1; n <= 9; n++){
            if(isRightLineNum(n,r,c,data)){
                data[r][c] = n;
                if(fill(data)){
                    return true;
                }
                data[r][c] = 0;
            }
        }
        return false;
    }

    public static boolean isRightLineNum(int n,int r,int c,int[][] data){
        if(checkRow(r,n,data) && checkCol(c,n,data) && checkBox(r,c,n,data)){
            return true;
        }
        return false;
    }

    public static boolean checkRow(int r, int n,int[][] data){
        for (int i=1; i<=9; i++) {
            if (data[r][i] == n) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkCol(int c, int n, int[][] data){
        for (int i=1; i<=9; i++) {
            if (data[i][c] == n) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkBox(int r,int c,int n,int[][] data){

        int row = ((int) Math.ceil(r / 3.0) - 1) * 3 + 1;
        int col = ((int) Math.ceil(c / 3.0) - 1) * 3 + 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (data[row + i][col + j] == n) {
                    return false;
                }
            }
        }
        return true;
    }
}

