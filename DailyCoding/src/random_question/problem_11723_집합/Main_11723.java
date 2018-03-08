package random_question.problem_11723_집합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_11723 {

    static final String add = "add";
    static final String check = "check";
    static final String remove = "remove";
    static final String toggle = "toggle";
    static final String all = "all";
    static final String empty = "empty";

    static int isCnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int initial = Integer.valueOf(br.readLine());

        boolean[] data = new boolean[20];

        for(int i=0; i<initial; i++){
            //data가 20까지는 long(1)에 떨어지는,boolean[20] 배열이 더 낫다.
            String[] strData =  br.readLine().split(" ");
            if(strData.length==1)
                solution(data,strData[0],-1);
            else
                solution(data,strData[0],Integer.valueOf(strData[1])-1);
        }
    }

    private static void solution(boolean[] data,String cmd,int num){
        StringBuilder sb = new StringBuilder();
        switch(cmd){
            case add:
                data[num] = true;
                isCnt++;
                break;
            case check:
                if(data[num]==true){
                    sb.append(1).append("\n");
                }else{
                    sb.append(0).append("\n");
                }
                break;
            case remove:
                data[num] = false;
                isCnt--;
                break;
            case toggle:
                if(data[num]==true){
                    data[num] = false;
                    isCnt--;
                }else{
                    data[num] = true;
                    isCnt++;
                }
                break;
            case all:
                if(isCnt!=20){
                    Arrays.fill(data,true);
                    isCnt = 20;
                }
                break;
            case empty:
                if(isCnt!=0){
                    isCnt = 0;
                    Arrays.fill(data,false);
                }
                break;
        }

        System.out.print(sb.toString());
    }
}
