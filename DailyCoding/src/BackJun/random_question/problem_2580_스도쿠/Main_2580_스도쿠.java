package random_question.problem_2580_스도쿠;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_2580_스도쿠 {

    private static boolean[][] possibleYval = new boolean[9][10]; //0은 안쓴다.
    private static boolean[][] possibleXval = new boolean[9][10]; //0은 안쓴다.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int data[][] = new int[9][9];

        for(int i=0; i<9; i++){
            int j = 0;
            int val = -1;
            for(String s:br.readLine().split(" ")){
                val = Integer.valueOf(s);
                possibleXval[i][val] = true; //false 애들만 해당 i라인에 가능하다는 말.
                possibleYval[j][val] = true; //false 것들만 해당 j라인에서 가능하다는 말.
                data[i][j++] = Integer.valueOf(val);
            }
        }
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

