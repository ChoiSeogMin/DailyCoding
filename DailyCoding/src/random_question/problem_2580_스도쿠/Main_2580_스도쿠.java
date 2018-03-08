package random_question.problem_2580_스도쿠;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2580_스도쿠 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int data[][] = new int[9][9];

        for(int i=0; i<9; i++){
            int j = 0;
            for(String s:br.readLine().split(" ")){
                data[i][j++] = Integer.valueOf(s);
            }
        }


    }
}
