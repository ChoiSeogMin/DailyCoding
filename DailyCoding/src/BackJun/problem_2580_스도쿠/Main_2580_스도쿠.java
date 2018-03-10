package random_question.problem_2580_스도쿠;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_2580_스도쿠 {

    private static ArrayList<EmptyNode> array = new ArrayList<EmptyNode>();

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

    /***
     * 빈 좌표는 array에 담는다.
     * @param data
     */
    private static void searchEmptyNode(int[][] data){

        for(int y=0; y<data.length; y++){
            for(int x=0; x<data[y].length; x++){
                if(data[y][x]==0){
                    array.add(new EmptyNode(y,x));
                }
            }
        }
    }

}

class EmptyNode{

    private int y;
    private int x;

    private ArrayList<Integer> possibleInteger = new ArrayList<>();

    public EmptyNode(int y, int x){
        this.y = y;
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
}
