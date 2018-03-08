package random_question.problem_1182_부분집합의합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1182_부분집합의합2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] initial = br.readLine().split(" ");
        int num = Integer.valueOf(initial[0]);
        int[] data = new int[num];
        int compare = Integer.valueOf(initial[1]);
        int i=0;
        int result = 0;
        for (String s : br.readLine().split(" ")) {
            data[i++] = Integer.valueOf(s);
        }

        for(int k:getSubset(data)){
            if(compare==k)
                result++;
        }

        if(compare == 0)
            result--;
        System.out.println(result);
    }


    public static int[] getSubset(int[] data) {

        int num = data.length;
        int[] subSetData = new int[1<<num];

        for(int i=0; i<1<<num; i++){
            for(int j=0; j<data.length; j++){
                if((i&(1<<j))==(1<<j)){
                    subSetData[i] += data[j];
                }
            }
        }
        return subSetData;
    }

}
